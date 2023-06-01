package services;

import java.time.LocalDateTime;
import java.util.List;

import actions.views.SystemConverter;
import actions.views.SystemView;
import constants.JpaConst;
import models.System;
import models.validators.SystemValidator;

/**
 * システムテーブルの操作に関わる処理を行うクラス
 */
public class SystemService extends ServiceBase {

    /**
     * 指定されたページ数の一覧画面に表示するデータを取得し、SystemViewのリストで返却する
     * @param page ページ数
     * @return 表示するデータのリスト
     */
    public List<SystemView> getPerPage(int page) {
        List<System> Systems = em.createNamedQuery(JpaConst.Q_SYS_GET_ALL, System.class)
                .setFirstResult(JpaConst.ROW_PER_PAGE * (page - 1))
                .setMaxResults(JpaConst.ROW_PER_PAGE)
                .getResultList();
        return SystemConverter.toViewList(Systems);
    }

    /**
     * リスト一覧画面に表示するデータを取得し、SystemViewのリストで返却する
     * @param page ページ数
     * @return 表示するデータのリスト
     */
    public List<SystemView> getListDataCount() {

        List<System> Systems = em.createNamedQuery(JpaConst.Q_SYS_GET_ALL, System.class)
                .getResultList();

        return SystemConverter.toViewList(Systems);
    }

    /**
     * システムテーブルのデータの件数を取得し、返却する
     * @return システムテーブルのデータの件数
     */
    public long countAll() {
        long systemCount = (long) em.createNamedQuery(JpaConst.Q_SYS_GET_ALL_COUNT, Long.class)
                .getSingleResult();
        return systemCount;
    }

    /**
     * Idを条件に取得したデータをSystemViewのインスタンスで返却する
     * @param id
     * @return 取得データのインスタンス
     */
    public SystemView findOne(int id) {
        System s = findOneInternal(id);
        return SystemConverter.toView(s);
    }

    /**
     * システムNoを条件に該当するデータの件数を取得し、返却する
     * @param systemId システムID
     * @return 該当するデータの件数
     */
    public long countBySysNo(Integer sysNo) {

        //指定したシステムNoを保持するシステムの件数を取得する
        long Systems_count = (long) em.createNamedQuery(JpaConst.Q_SYS_GET_BY_SYS_NO_COUNT, Long.class)
                .setParameter(JpaConst.JPQL_PARM_SYS_NO, sysNo)
                .getSingleResult();
        return Systems_count;
    }

    /**
     * 画面から入力されたシステムの登録内容を元にデータを1件作成し、システムテーブルに登録する
     * @param sv 画面から入力されたシステムの登録内容
     * @return バリデーションや登録処理中に発生したエラーのリスト
     */
    public List<String> create(SystemView sv) {

        //登録日時、更新日時は現在時刻を設定する
        LocalDateTime now = LocalDateTime.now();
        sv.setInpDate(now);
        sv.setUpdDate(now);

        //登録内容のバリデーションを行う
        List<String> errors = SystemValidator.validate(this, sv, true);

        //バリデーションエラーがなければデータを登録する
        if (errors.size() == 0) {
            em.getTransaction().begin();
            em.persist(SystemConverter.toModel(sv));
            em.getTransaction().commit();
        }

        //エラーを返却（エラーがなければ0件の空リスト）
        return errors;
    }

    /**
     * 画面から入力されたシステムの更新内容を元にデータを1件作成し、システムテーブルを更新する
     * @param uv 画面から入力されたシステムの登録内容
     * @param pepper pepper文字列
     * @return バリデーションや更新処理中に発生したエラーのリスト
     */
    public List<String> update(SystemView sv) {
        //リソースIDを条件に登録済みのシステム情報を取得する
        SystemView savedsystem = findOne(sv.getId());

        boolean validateSysNo = false;
        if (!savedsystem.getSysNo().equals(sv.getSysNo())) {
            //システムNoを更新する場合

            //システムNoについてのバリデーションを行う
            validateSysNo = true;
            //変更後のシステムNoを設定する
            savedsystem.setSysNo(sv.getSysNo());
        }


        savedsystem.setSysName(sv.getSysName()); //変更後の氏名を設定する
        savedsystem.setSysLevel(sv.getSysLevel()); //変更後のシステム開示レベルを設定する
        savedsystem.setUpdUserId(sv.getUpdUserId());

        //更新日時に現在時刻を設定する
        LocalDateTime today = LocalDateTime.now();
        savedsystem.setUpdDate(today);

        //更新内容についてバリデーションを行う
        List<String> errors = SystemValidator.validate(this, savedsystem, validateSysNo);

        //バリデーションエラーがなければデータを更新する
        if (errors.size() == 0) {
            updateMain(savedsystem);
        }

        //エラーを返却（エラーがなければ0件の空リスト）
        return errors;
    }

    /**
     * idを条件にシステムデータを論理削除する
     * @param id
     */
    public void destroy(Integer id) {

        //idを条件に登録済みのシステム情報を取得する
        SystemView savedsystem = findOne(id);

        //更新日時に現在時刻を設定する
        LocalDateTime today = LocalDateTime.now();
        savedsystem.setUpdDate(today);

        //論理削除フラグをたてる
        savedsystem.setDelFlg(JpaConst.FLG_ON);

        //更新処理を行う
        updateMain(savedsystem);

    }


    /**
     * idを条件にデータを1件取得し、Systemのインスタンスで返却する
     * @param id
     * @return 取得データのインスタンス
     */
    private System findOneInternal(int id) {
        System u = em.find(System.class, id);

        return u;
    }


    /**
     * システムデータを更新する
     * @param uv 画面から入力されたシステムの登録内容
     */
    private void updateMain(SystemView uv) {

        em.getTransaction().begin();
        System e = findOneInternal(uv.getId());
        SystemConverter.copyViewToModel(e, uv);
        em.getTransaction().commit();

    }

}