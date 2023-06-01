package services;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.NoResultException;

import actions.views.UserConverter;
import actions.views.UserView;
import constants.JpaConst;
import models.User;
import models.validators.UserValidator;
import utils.EncryptUtil;

/**
 * ユーザーテーブルの操作に関わる処理を行うクラス
 */
public class UserService extends ServiceBase {

    /**
     * 指定されたページ数の一覧画面に表示するデータを取得し、UserViewのリストで返却する
     * @param page ページ数
     * @return 表示するデータのリスト
     */
    public List<UserView> getPerPage(int page) {
        List<User> Users = em.createNamedQuery(JpaConst.Q_USER_GET_ALL, User.class)
                .setFirstResult(JpaConst.ROW_PER_PAGE * (page - 1))
                .setMaxResults(JpaConst.ROW_PER_PAGE)
                .getResultList();
        return UserConverter.toViewList(Users);
    }

    /**
     * リスト一覧画面に表示するデータを取得し、UserViewのリストで返却する
     * @param page ページ数
     * @return 表示するデータのリスト
     */
    public List<UserView> getListDataCount() {

        List<User> Users = em.createNamedQuery(JpaConst.Q_USER_GET_ALL, User.class)
                .getResultList();

        return UserConverter.toViewList(Users);
    }

    /**
     * 利用者テーブルのデータの件数を取得し、返却する
     * @return 利用者テーブルのデータの件数
     */
    public long countAll() {
        long userCount = (long) em.createNamedQuery(JpaConst.Q_USER_GET_ALL_COUNT, Long.class)
                .getSingleResult();
        return userCount;
    }

    /**
     * ユーザーID、パスワードを条件に取得したデータをUserViewのインスタンスで返却する
     * @param userId ユーザーID
     * @param plainPass パスワード文字列
     * @param pepper pepper文字列
     * @return 取得データのインスタンス 取得できない場合null
     */
    public UserView findOne(String userId, String plainPass, String pepper) {
        User u = null;
        try {
            //パスワードのハッシュ化
            String pass = EncryptUtil.getPasswordEncrypt(plainPass, pepper);

            //ユーザーIDとハッシュ化済パスワードを条件に未削除の利用者を1件取得する
            u = em.createNamedQuery(JpaConst.Q_USER_GET_BY_USER_ID_AND_PASS, User.class)
                    .setParameter(JpaConst.JPQL_PARM_USER_ID, userId)
                    .setParameter(JpaConst.JPQL_PARM_PASS, pass)
                    .getSingleResult();
        } catch (NoResultException ex) {
        }
        return UserConverter.toView(u);

    }

    /**
     * Idを条件に取得したデータをUserViewのインスタンスで返却する
     * @param id
     * @return 取得データのインスタンス
     */
    public UserView findOne(int id) {
        User u = findOneInternal(id);
        return UserConverter.toView(u);
    }

    /**
     * ユーザーIDを条件に該当するデータの件数を取得し、返却する
     * @param userId ユーザーID
     * @return 該当するデータの件数
     */
    public long countByCode(String userId) {

        //指定したユーザーIDを保持する利用者の件数を取得する
        long Users_count = (long) em.createNamedQuery(JpaConst.Q_USER_GET_BY_USER_ID_COUNT, Long.class)
                .setParameter(JpaConst.JPQL_PARM_USER_ID, userId)
                .getSingleResult();
        return Users_count;
    }

    /**
     * 画面から入力された利用者の登録内容を元にデータを1件作成し、利用者テーブルに登録する
     * @param uv 画面から入力された利用者の登録内容
     * @param pepper pepper文字列
     * @return バリデーションや登録処理中に発生したエラーのリスト
     */
    public List<String> create(UserView uv, String pepper) {

        //パスワードをハッシュ化して設定
        String pass = EncryptUtil.getPasswordEncrypt(uv.getPassword(), pepper);
        uv.setPassword(pass);

        //登録日時、更新日時は現在時刻を設定する
        LocalDateTime now = LocalDateTime.now();
        uv.setInpDate(now);
        uv.setUpdDate(now);

        //登録内容のバリデーションを行う
        List<String> errors = UserValidator.validate(this, uv, true, true);

        //バリデーションエラーがなければデータを登録する
        if (errors.size() == 0) {
            create(uv);
        }

        //エラーを返却（エラーがなければ0件の空リスト）
        return errors;
    }

    /**
     * 画面から入力された利用者の更新内容を元にデータを1件作成し、利用者テーブルを更新する
     * @param uv 画面から入力された利用者の登録内容
     * @param pepper pepper文字列
     * @return バリデーションや更新処理中に発生したエラーのリスト
     */
    public List<String> update(UserView uv, String pepper) {

        //リソースIDを条件に登録済みの利用者情報を取得する
        UserView saveduser = findOne(uv.getId());



        boolean validateCode = false;
        if (!saveduser.getUserId().equals(uv.getUserId())) {
            //ユーザーIDを更新する場合

            //ユーザーIDについてのバリデーションを行う
            validateCode = true;
            //変更後のユーザーIDを設定する
            saveduser.setUserId(uv.getUserId());
        }

        boolean validatePass = false;
        if (uv.getPassword() != null && !uv.getPassword().equals("")) {
            //パスワードに入力がある場合

            //パスワードについてのバリデーションを行う
            validatePass = true;

            //変更後のパスワードをハッシュ化し設定する
            saveduser.setPassword(
                    EncryptUtil.getPasswordEncrypt(uv.getPassword(), pepper));
        }

        saveduser.setUserName(uv.getUserName()); //変更後の氏名を設定する
        saveduser.setSysLevel(uv.getSysLevel()); //変更後のシステム開示レベルを設定する
        saveduser.setMenuLevel(uv.getMenuLevel()); //変更後のメニュー利用レベルを設定する

        saveduser.setUpdUserId(uv.getUpdUserId());

        //更新日時に現在時刻を設定する
        LocalDateTime today = LocalDateTime.now();
        saveduser.setUpdDate(today);

        //更新内容についてバリデーションを行う
        List<String> errors = UserValidator.validate(this, saveduser, validateCode, validatePass);

        //バリデーションエラーがなければデータを更新する
        if (errors.size() == 0) {
            update(saveduser);
        }

        //エラーを返却（エラーがなければ0件の空リスト）
        return errors;
    }

    /**
     * idを条件に利用者データを論理削除する
     * @param id
     */
    public void destroy(Integer id) {

        //idを条件に登録済みの利用者情報を取得する
        UserView saveduser = findOne(id);

        //更新日時に現在時刻を設定する
        LocalDateTime today = LocalDateTime.now();
        saveduser.setUpdDate(today);

        //論理削除フラグをたてる
        saveduser.setDelFlg(JpaConst.FLG_ON);

        //更新処理を行う
        update(saveduser);

    }

    /**
     * ユーザーIDとパスワードを条件に検索し、データが取得できるかどうかで認証結果を返却する
     * @param userId ユーザーID
     * @param plainPass パスワード
     * @param pepper pepper文字列
     * @return 認証結果を返却す(成功:true 失敗:false)
     */
    public Boolean validateLogin(String userId, String plainPass, String pepper) {

        boolean isValidUser = false;
        if (userId != null && !userId.equals("") && plainPass != null && !plainPass.equals("")) {

            UserView uv = findOne(userId, plainPass, pepper);

            if (uv != null && uv.getId() != null) {

                //データが取得できた場合、認証成功
                isValidUser = true;
            }
        }

        //認証結果を返却する
        return isValidUser;
    }

    /**
     * userIdを条件にデータを複数取得し、Userのインスタンスで返却する
     * @param userId
     * @return 取得データのインスタンス
     */
    public List<UserView> getSearchUserIdPerPage(String userId ,int page) {

        List<User> Users = em.createNamedQuery(JpaConst.Q_USER_GET_BY_USER_ID, User.class)
                .setParameter(JpaConst.JPQL_PARM_USER_ID, "%" + userId + "%")
                .setFirstResult(JpaConst.ROW_PER_PAGE * (page - 1))
                .setMaxResults(JpaConst.ROW_PER_PAGE)
                .getResultList();
        return UserConverter.toViewList(Users);
    }


    /**
     * idを条件にデータを1件取得し、Userのインスタンスで返却する
     * @param id
     * @return 取得データのインスタンス
     */
    private User findOneInternal(int id) {
        User u = em.find(User.class, id);

        return u;
    }

    /**
     * 利用者データを1件登録する
     * @param uv 利用者データ
     * @return 登録結果(成功:true 失敗:false)
     */
    private void create(UserView uv) {

        em.getTransaction().begin();
        em.persist(UserConverter.toModel(uv));
        em.getTransaction().commit();

    }

    /**
     * 利用者データを更新する
     * @param uv 画面から入力された利用者の登録内容
     */
    private void update(UserView uv) {

        em.getTransaction().begin();
        User e = findOneInternal(uv.getId());
        UserConverter.copyViewToModel(e, uv);
        em.getTransaction().commit();

    }

}