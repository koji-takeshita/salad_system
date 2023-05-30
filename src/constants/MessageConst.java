package constants;

/**
 * 各出力メッセージを定義するEnumクラス
 *
 */
public enum MessageConst {

    //認証
    I_LOGINED("ログインしました"),
    E_LOGINED("ログインに失敗しました。"),
    I_LOGOUT("ログアウトしました。"),

    //DB更新
    I_REGISTERED("登録が完了しました。"),
    I_UPDATED("更新が完了しました。"),
    I_DELETED("削除が完了しました。"),

    //バリデーション
    E_NONAME("ユーザー名を入力してください。"),
    E_NOPASSWORD("パスワードを入力してください。"),
    E_NOUSER_ID("ユーザーIDを入力してください。"),
    E_USER_ID_EXIST("入力されたユーザーIDの情報は既に存在しています。"),
    E_NOBOOK_ID("書籍IDを数字で入力してください。"),
    E_BOOK_ID_EXIST("入力された書籍IDの情報は既に存在しています。"),
    E_BOOK_EXIST("入力された書籍名・ジャンル名・シリーズ番号の組は既に存在しています。"),
    E_SEREIES_NO("シリーズ番号を数字で入力してください。"),
    E_NOBOOK_NAME("書籍名を入力してください。");



    /**
     * 文字列
     */
    private final String text;

    /**
     * コンストラクタ
     */
    private MessageConst(final String text) {
        this.text = text;
    }

    /**
     * 値(文字列)取得
     */
    public String getMessage() {
        return this.text;
    }
}