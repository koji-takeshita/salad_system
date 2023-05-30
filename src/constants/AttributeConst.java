package constants;


/**
 * 画面の項目値等を定義するEnumクラス
 *
 */
public enum AttributeConst {

    //フラッシュメッセージ
    FLUSH("flush"),

    //一覧画面共通
    MAX_ROW("maxRow"),
    PAGE("page"),

    //入力フォーム共通
    TOKEN("_token"),
    ERR("errors"),

    //ログイン中のユーザー
    LOGIN_USER("login_user"),

    //ログイン画面
    LOGIN_ERR("loginError"),

    //利用者管理
    USER("user"),
    USERS("users"),
    SEARCH_REST("search_rest"),
    USERS_COUNT("users_count"),
    ID("id"),
    USER_ID("user_id"),
    USER_NAME("user_name"),
    USER_PASS("password"),

    //開示レベル
    SYS_ADMIN(9),
    SYS_MEMBER(1),
    SYS_COMMON(0),

    //利用レベル
    MENU_ADMIN(9),
    MENU_UPDATE(1),
    MENU_REFERENCE(0),


    //システム情報
    SYSTEM("system"),
    SYSTEMS("systems"),
    SYSTEMS_COUNT("systems_count"),
    SYSTEM_NO("book_no"),
    SYSTEM_NAME("book_id"),
    SYS_LEVEL("system_level"),
    MENU_LEVEL("menu_level"),

    //組み合わせ情報
    SET("set"),
    SETS("sets"),
    CUL_NO("cul_no"),
    ROW_NO("row_no"),

    //フラグ
    DEL_FLG("del_flg"),
    BOOKED_FLG("booked_flg"),
    FLG_ON(1),
    FLG_OFF(0),

    SEARCH("search"),
    KEY_WORD("key_word");

    private final String text;
    private final Integer i;

    private AttributeConst(final String text) {
        this.text = text;
        this.i = null;
    }

    private AttributeConst(final Integer i) {
        this.text = null;
        this.i = i;
    }

    public String getValue() {
        return this.text;
    }

    public Integer getIntegerValue() {
        return this.i;
    }

}
