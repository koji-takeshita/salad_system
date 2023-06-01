package models.validators;

import java.util.ArrayList;
import java.util.List;

import actions.views.UserView;
import constants.MessageConst;
import services.UserService;

/**
 * 利用者インスタンスに設定されている値のバリデーションを行うクラス
 *
 */
public class UserValidator {

    /**
     * 利用者インスタンスの各項目についてバリデーションを行う
     * @param service 呼び出し元Serviceクラスのインスタンス
     * @param uv UserViewのインスタンス
     * @param codeDuplicateCheckFlag ユーザーIDの重複チェックを実施するかどうか(実施する:true 実施しない:false)
     * @param passwordCheckFlag パスワードの入力チェックを実施するかどうか(実施する:true 実施しない:false)
     * @return エラーのリスト
     */
    public static List<String> validate(
            UserService service, UserView uv, Boolean codeDuplicateCheckFlag, Boolean passwordCheckFlag) {
        List<String> errors = new ArrayList<String>();

        //ユーザーIdのチェック
        String userIdError = validateCode(service, uv.getUserId(), codeDuplicateCheckFlag);
        if (!userIdError.equals("")) {
            errors.add(userIdError);
        }

        //ユーザー名のチェック
        String nameError = validateName(uv.getUserName());
        if (!nameError.equals("")) {
            errors.add(nameError);
        }

        //パスワードのチェック
        String passError = validatePassword(uv.getPassword(), passwordCheckFlag);
        if (!passError.equals("")) {
            errors.add(passError);
        }

        return errors;
    }

    /**
     * ユーザーIdの入力チェックを行い、エラーメッセージを返却
     * @param service UserServiceのインスタンス
     * @param userId ユーザーID
     * @param userIdDuplicateCheckFlag ユーザーIDの重複チェックを実施するかどうか(実施する:true 実施しない:false)
     * @return エラーメッセージ
     */
    private static String validateCode(UserService service, String userId, Boolean userIdDuplicateCheckFlag) {

        //入力値がなければエラーメッセージを返却
        if (userId == null || userId.equals("")) {
            return MessageConst.E_NOUSER_ID.getMessage();
        }

        if (userIdDuplicateCheckFlag) {
            //ユーザーIDの重複チェックを実施

            long UsersCount = isDuplicateUser(service, userId);

            //同一社員番号が既に登録されている場合はエラーメッセージを返却
            if (UsersCount > 0) {
                return MessageConst.E_USER_ID_EXIST.getMessage();
            }
        }

        //エラーがない場合は空文字を返却
        return "";
    }

    /**
     * @param service UserServiceのインスタンス
     * @param userId ユーザーID
     * @return 利用者テーブルに登録されている同一ユーザーIDのデータの件数
     */
    private static long isDuplicateUser(UserService service, String userId) {

        long UsersCount = service.countByCode(userId);
        return UsersCount;
    }

    /**
     * ユーザー名に入力値があるかをチェックし、入力値がなければエラーメッセージを返却
     * @param name ユーザー名
     * @return エラーメッセージ
     */
    private static String validateName(String name) {

        if (name == null || name.equals("")) {
            return MessageConst.E_NONAME.getMessage();
        }

        //入力値がある場合は空文字を返却
        return "";
    }

    /**
     * パスワードの入力チェックを行い、エラーメッセージを返却
     * @param password パスワード
     * @param passwordCheckFlag パスワードの入力チェックを実施するかどうか(実施する:true 実施しない:false)
     * @return エラーメッセージ
     */
    private static String validatePassword(String password, Boolean passwordCheckFlag) {

        //入力チェックを実施 かつ 入力値がなければエラーメッセージを返却
        if (passwordCheckFlag && (password == null || password.equals(""))) {
            return MessageConst.E_NOPASSWORD.getMessage();
        }

        //エラーがない場合は空文字を返却
        return "";
    }
}