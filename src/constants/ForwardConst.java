package constants;

/**
 * リクエストパラメーターの変数名、変数値、jspファイルの名前等画面遷移に関わる値を定義するEnumクラス
 *
 */
public enum ForwardConst {

    //action
    ACT("action"),
    ACT_TOP("Top"),
    ACT_USER("User"),
    ACT_SYSTEM("System"),
    ACT_SET("Set"),
    ACT_AUTH("Auth"),
    ACT_RSV("Reserve"),

    //command
    CMD("command"),
    CMD_NONE(""),
    CMD_INDEX("index"),
    CMD_TOP("top"),
    CMD_SEARCH("search"),
    CMD_SHOW("show"),
    CMD_RSV("reserve"),
    CMD_SHOW_LOGIN("showLogin"),
    CMD_LOGIN("login"),
    CMD_LOGOUT("logout"),
    CMD_NEW("entryNew"),
    CMD_CREATE("create"),
    CMD_EDIT("edit"),
    CMD_UPDATE("update"),
    CMD_DESTROY("destroy"),

    //jsp
    FW_ERR_UNKNOWN("error/unknown"),
    FW_TOP_INDEX("topPage/index"),
    FW_LOGIN("login/login"),
    FW_USER_INDEX("users/index"),
    FW_USER_SHOW("users/show"),
    FW_USER_NEW("users/new"),
    FW_USER_EDIT("users/edit"),
    FW_USER_SEARCH("users/search"),
    FW_SYS_INDEX("systems/index"),
    FW_SYS_SHOW("systems/show"),
    FW_SYS_NEW("systems/new"),
    FW_SYS_EDIT("systems/edit"),
    FW_RSV_INDEX("reserves/index"),
    FW_RSV_SHOW("reserves/show"),
    FW_RSV_NEW("reserves/new"),
    FW_RSV_EDIT("reserves/edit");

    /**
     * 文字列
     */
    private final String text;

    /**
     * コンストラクタ
     */
    private ForwardConst(final String text) {
        this.text = text;
    }

    /**
     * 値(文字列)取得
     */
    public String getValue() {
        return this.text;
    }

}