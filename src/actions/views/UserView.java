package actions.views;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 利用者情報について画面の入力値・出力値を扱うViewモデル
 *
 */
@Getter //全てのクラスフィールドについてgetterを自動生成する(Lombok)
@Setter //全てのクラスフィールドについてsetterを自動生成する(Lombok)
@NoArgsConstructor //引数なしコンストラクタを自動生成する(Lombok)
@AllArgsConstructor //全てのクラスフィールドを引数にもつ引数ありコンストラクタを自動生成する(Lombok)
public class UserView {

    /**
     * リソースid
     */
    private Integer id;

    /**
     * ユーザーID
     */
    private String userId;

    /**
     * ユーザー名
     */
    private String userName;

    /**
     * パスワード
     */
    private String password;

    /**
     * システム開示レベル（一般：0、管理者：9）
     */
    private Integer sysLevel;

    /**
     * メニュー利用レベル（一般：0、管理者：9）
     */
    private Integer menuLevel;

    /**
     *登録日時
     */
    private LocalDateTime inpDate;

    /**
     *登録ユーザーID
     */
    private String inpUserId;

    /**
     * 更新日時
     */
    private LocalDateTime updDate;

    /**
     * 更新ユーザーID
     */
    private String updUserId;

    /**
     * 削除された従業員かどうか（現役：0、削除済み：1）
     */
    private Integer delFlg;

}
