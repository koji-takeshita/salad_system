package models.validators;

import java.util.ArrayList;
import java.util.List;

import actions.views.SystemView;
import constants.MessageConst;
import services.SystemService;

/**
 * システムインスタンスに設定されている値のバリデーションを行うクラス
 *
 */
public class SystemValidator {

    /**
     * システムインスタンスの各項目についてバリデーションを行う
     * @param service 呼び出し元Serviceクラスのインスタンス
     * @param sv SystemViewのインスタンス
     * @param codeDuplicateCheckFlag ユーザーIDの重複チェックを実施するかどうか(実施する:true 実施しない:false)
     * @param passwordCheckFlag パスワードの入力チェックを実施するかどうか(実施する:true 実施しない:false)
     * @return エラーのリスト
     */
    public static List<String> validate(
            SystemService service, SystemView sv, Boolean noDuplicateCheckFlag) {
        List<String> errors = new ArrayList<String>();

        //システムNoのチェック
        String sysNoError = validateSysNo(service, sv.getSysNo(), noDuplicateCheckFlag);
        if (!sysNoError.equals("")) {
            errors.add(sysNoError);
        }

        //システム名のチェック
        String sysNameError = validateName(sv.getSysName());
        if (!sysNameError.equals("")) {
            errors.add(sysNameError);
        }

        return errors;
    }

    /**
     * システムNOの入力チェックを行い、エラーメッセージを返却
     * @param service SystemServiceのインスタンス
     * @param sysNo システムNo
     * @param noDuplicateCheckFlag システムNoの重複チェックを実施するかどうか(実施する:true 実施しない:false)
     * @return エラーメッセージ
     */
    private static String validateSysNo(SystemService service, Integer sysNo, Boolean noDuplicateCheckFlag) {

        //入力値がなければエラーメッセージを返却
        if (sysNo == null || sysNo == Integer.MIN_VALUE  ) {
            return MessageConst.E_NO_SYS_NO.getMessage();
        }

        if (noDuplicateCheckFlag) {
            //システムNoの重複チェックを実施

            long SystemsCount = isDuplicateSystem(service, sysNo);

            //同一システムNoが既に登録されている場合はエラーメッセージを返却
            if (SystemsCount > 0) {
                return MessageConst.E_SYS_NO_EXIST.getMessage();
            }
        }

        //エラーがない場合は空文字を返却
        return "";
    }

    /**
     * @param service SystemServiceのインスタンス
     * @param sysNo システムNo
     * @return システムテーブルに登録されている同一システムNoのデータの件数
     */
    private static long isDuplicateSystem(SystemService service, Integer sysNo) {

        long SystemsCount = service.countBySysNo(sysNo);
        return SystemsCount;
    }

    /**
     * 名に入力値があるかをチェックし、入力値がなければエラーメッセージを返却
     * @param name 名
     * @return エラーメッセージ
     */
    private static String validateName(String name) {

        if (name == null || name.equals("")) {
            return MessageConst.E_NO_SYS_NAME.getMessage();
        }

        //入力値がある場合は空文字を返却
        return "";
    }


}