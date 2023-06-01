package constants;

/**
 * DB関連の項目値を定義するインターフェース
 * ※インターフェイスに定義した変数は public static final 修飾子がついているとみなされる
 */
public interface JpaConst {

    //persistence-unit名
    String PERSISTENCE_UNIT_NAME = "salad_system";

    //データ取得件数の最大値
    int ROW_PER_PAGE = 5; //1ページに表示するレコードの数

    int SYS_AD = 9; //管理者レベル
    int SYS_MEMBER = 1; //会員レベル
    int SYS_NORMAL = 0; //一般レベル

    int MENU_AD = 9; //管理者権限
    int MENU_UPD = 1; //更新権限
    int MENU_REF = 0; //参照権限

    int FLG_ON = 1; //削除フラグON(削除済み)
    int FLG_OFF = 0; //削除フラグOFF(現役)

    //システムテーブル
    String TABLE_USER = "users"; //テーブル名
    //利用者テーブルカラム
    String USER_COL_ID = "id"; //リソースid
    String USER_COL_USER_ID = "user_id"; //ユーザーID
    String USER_COL_NAME = "user_name"; //ユーザー名
    String USER_COL_PASS = "password"; //パスワード
    String USER_COL_SYS_LVL = "system_level"; //システムを開示するレベル
    String USER_COL_MENU_LVL = "menu_level"; //使用可能機能を判断するレベル
    String USER_COL_INP_DATE = "inp_date"; //登録日時
    String USER_COL_INP_USER = "inp_user_id"; //登録ユーザーID
    String USER_COL_UPD_DATE = "upd_date"; //更新日時
    String USER_COL_UPD_USER = "upd_user_id"; //更新ユーザーID
    String USER_COL_DEL_FLG = "del_flg"; //削除フラグ


    //システムテーブル
    String TABLE_SYS = "systems"; //テーブル名
    //システムテーブルカラム
    String SYS_COL_ID = "id"; //(リソースid)
    String SYS_COL_NO = "system_no"; //システムNo
    String SYS_COL_NAME = "system_name"; //システム名
    String SYS_COL_SYS_LVL = "system_level"; //システムレベル
    String SYS_COL_INP_DATE = "inp_date"; //登録日
    String SYS_COL_INP_USER = "inp_user_id"; //登録した人のユーザーID
    String SYS_COL_UPD_DATE = "upd_date"; //更新日
    String SYS_COL_UPD_USER = "upd_user_id"; //更新した人のユーザーID
    String SYS_COL_DEL_FLG = "del_flg"; //削除フラグ


    //組み合わせテーブル
    String TABLE_SET = "sets"; //テーブル名
    //システムテーブルカラム
    String SET_COL_ID = "id"; //(リソースid)
    String SET_COL_SYS_NO = "system_no"; //システムNo
    String SET_COL_COL = "cul_set_no"; //列NO
    String SET_COL_ROW = "row_set_no"; //行NO
    String SET_COL_RSV_FLG = "reserve_flg"; //削除フラグ
    String SET_COL_INP_DATE = "inp_date"; //登録日
    String SET_COL_INP_USER = "inp_user_id"; //登録した人のユーザーID
    String SET_COL_UPD_DATE = "upd_date"; //更新日
    String SET_COL_UPD_USER = "upd_user_id"; //更新した人のユーザーID
    String SET_COL_DEL_FLG = "del_flg"; //削除フラグ

    //Entity名
    String ENTITY_USER = "user"; //利用者
    String ENTITY_SYS = "system"; //システム
    String ENTITY_SET = "set"; //組み合わせ

    //JPQL内パラメータ
    String JPQL_PARM_ID = "id"; //ID
    String JPQL_PARM_USER = "user"; //ユーザー
    String JPQL_PARM_USER_ID = "userId"; //ID
    String JPQL_PARM_USER_NAME = "userName"; //利用者名
    String JPQL_PARM_PASS = "password"; //パスワード
    String JPQL_PARM_SYS_LVL = "sysLvl"; //システムレベル
    String JPQL_PARM_MENU_LVL = "menuLvl"; //メニューレベル
    String JPQL_PARM_SYS_NO = "sysNo"; //システムNo
    String JPQL_PARM_SYS_NAME = "sysName"; //システム名
    String JPQL_PARM_COL_NO = "colNo"; //列NO
    String JPQL_PARM_ROW_NO = "rowNo";//行No
    String JPQL_PARM_RSV_FLG = "reserveFlg";//予約済みフラグ

    //NamedQueryの nameとquery
    //全ての利用者をユーザーidの降順(最新が上)に取得する
    String Q_USER_GET_ALL = ENTITY_USER + ".getUserAll"; //name
    String Q_USER_GET_ALL_DEF = "SELECT u "
                               + "FROM User AS u "
                               + "WHERE u.delFlg = '0'"
                               + "ORDER BY u.id DESC"; //query
    //全ての利用者の件数を取得する
    String Q_USER_GET_ALL_COUNT = ENTITY_USER + ".countUser";
    String Q_USER_GET_ALL_COUNT_DEF = "SELECT COUNT(u) "
                              + "FROM User AS u "
                              + "WHERE u.delFlg = '0'";
    //ユーザーIDとハッシュ化済パスワードを条件に未削除の利用者を取得する
    String Q_USER_GET_BY_USER_ID_AND_PASS = ENTITY_USER + ".getUserByUserIdAndPass";
    String Q_USER_GET_BY_USER_ID_AND_PASS_DEF = "SELECT u "
                                              + "FROM User AS u "
                                              + "WHERE u.delFlg = 0 AND u.userId = :"
                                              + JPQL_PARM_USER_ID
                                              + " AND u.password = :"
                                              + JPQL_PARM_PASS;
    //ユーザーのIDを条件に未削除の利用者を取得する
    String Q_USER_GET_BY_USER_ID = ENTITY_USER + ".getUserByUserId";
    String Q_USER_GET_BY_USER_ID_DEF = "SELECT u "
                                       + "FROM User AS u "
                                       + "WHERE u.delFlg = 0 AND u.userId = :"
                                       + JPQL_PARM_USER_ID
                                       + " ORDER BY u.id DESC";
    //ユーザーのIDを条件に未削除の利用者の件数を取得する
    String Q_USER_GET_BY_USER_ID_COUNT = ENTITY_USER + ".countUserByUserId";
    String Q_USER_GET_BY_USER_ID_COUNT_DEF = "SELECT COUNT(u) "
                              + "FROM User AS u "
                              + "WHERE u.delFlg = 0 AND u.userId = :"
                              + JPQL_PARM_USER_ID;
    //システムレベルを条件に未削除の利用者を取得する
    String Q_USER_GET_BY_SYS_LVL = ENTITY_SYS + ".getUserBySysLvl";
    String Q_USER_GET_BY_SYS_LVL_DEF = "SELECT u "
                                      + "FROM User AS u "
                                      + "WHERE u.delFlg = 0 AND u.sysLevel = :"
                                      + JPQL_PARM_SYS_LVL
                                      + " ORDER BY u.id DESC";
    //システムレベルを条件に未削除の利用者の件数を取得する
    String Q_USER_GET_BY_SYS_LVL_COUNT = ENTITY_USER + ".countUserBySysLvl";
    String Q_USER_GET_BY_SYS_LVL_COUNT_DEF = "SELECT COUNT(u) "
                              + "FROM User AS u "
                              + "WHERE u.delFlg = 0 AND u.sysLevel = :"
                              + JPQL_PARM_SYS_LVL;
    //メニューレベルを条件に未削除の利用者を取得する
    String Q_USER_GET_BY_MENU_LVL = ENTITY_SYS + ".getUserByMenuLvl";
    String Q_USER_GET_BY_MENU_LVL_DEF = "SELECT u "
                                      + "FROM User AS u "
                                      + "WHERE u.delFlg = 0 AND u.menuLevel = :"
                                      + JPQL_PARM_MENU_LVL
                                      + " ORDER BY u.id DESC";
    //メニューレベルを条件に未削除の利用者の件数を取得する
    String Q_USER_GET_BY_MENU_LVL_COUNT = ENTITY_SYS + ".countUserByMenuLvl";
    String Q_USER_GET_BY_MENU_LVL_COUNT_DEF = "SELECT COUNT(u) "
                                      + "FROM User AS u "
                                      + "WHERE u.delFlg = 0 AND u.menuLevel = :"
                                      + JPQL_PARM_MENU_LVL;



    //全てのシステムをシステムNOの降順(最新が上)に取得する
    String Q_SYS_GET_ALL = ENTITY_SYS + ".getSysAll"; //name
    String Q_SYS_GET_ALL_DEF = "SELECT s "
                               + "FROM System AS s "
                               + "WHERE s.delFlg = '0'"
                               + "ORDER BY s.id DESC"; //query
    //全てのシステムの件数を取得する
    String Q_SYS_GET_ALL_COUNT = ENTITY_SYS + ".countSys";
    String Q_SYS_GET_ALL_COUNT_DEF = "SELECT COUNT(s) "
                              + "FROM System AS s "
                              + "WHERE s.delFlg = '0'";
    //システムNoを条件に未削除のシステムを取得する
    String Q_SYS_GET_BY_SYS_NO = ENTITY_SYS + ".getSysBySysNo";
    String Q_SYS_GET_BY_SYS_NO_DEF = "SELECT s "
                                       + "FROM System AS s "
                                       + "WHERE s.delFlg = 0 AND s.sysNo = :"
                                       + JPQL_PARM_SYS_NO
                                       + " ORDER BY s.id DESC";
    //システムNoを条件に未削除のシステム件数を取得する
    String Q_SYS_GET_BY_SYS_NO_COUNT = ENTITY_SYS + ".countSysBySysNo";
    String Q_SYS_GET_BY_SYS_NO_COUNT_DEF = "SELECT COUNT(s) "
                                       + "FROM System AS s "
                                       + "WHERE s.delFlg = 0 AND s.sysNo = :"
                                       + JPQL_PARM_SYS_NO;
    //システムレベルを条件に未削除のシステムを取得する
    String Q_SYS_GET_BY_SYS_LVL = ENTITY_SYS + ".getSysBySysLvl";
    String Q_SYS_GET_BY_SYS_LVL_DEF = "SELECT s "
                                      + "FROM System AS s "
                                      + "WHERE s.delFlg = 0 AND s.sysLevel = :"
                                      + JPQL_PARM_SYS_LVL
                                      + " ORDER BY s.id DESC";
    //システムレベルを条件に未削除のシステム件数を取得する
    String Q_SYS_GET_BY_SYS_LVL_COUNT = ENTITY_SYS + ".countSysBySysLvl";
    String Q_SYS_GET_BY_SYS_LVL_COUNT_DEF = "SELECT COUNT(s) "
                                      + "FROM System AS s "
                                      + "WHERE s.delFlg = 0 AND s.sysLevel = :"
                                      + JPQL_PARM_SYS_LVL;




    //全ての組み合わせをシステムNOの降順(最新が上)に取得する
    String Q_SET_GET_ALL = ENTITY_SET + ".getSetAll"; //name
    String Q_SET_GET_ALL_DEF = "SELECT s "
                               + "FROM Set AS s "
                               + "WHERE s.delFlg = '0'"
                               + "ORDER BY s.id DESC"; //query
    //全ての組み合わせの件数を取得する
    String Q_SET_GET_ALL_COUNT = ENTITY_SET + ".countSet";
    String Q_SET_GET_ALL_COUNT_DEF = "SELECT COUNT(s) "
                              + "FROM Set AS s "
                              + "WHERE s.delFlg = '0'";
    //システムNoを条件に未削除の組み合わせを取得する
    String Q_SET_GET_BY_SYS_NO = ENTITY_SET + ".getSetBySysNo";
    String Q_SET_GET_BY_SYS_NO_DEF = "SELECT s "
                                       + "FROM Set AS s "
                                       + "WHERE s.delFlg = 0 AND s.sysNo = :"
                                       + JPQL_PARM_SYS_NO
                                       + " ORDER BY s.id DESC";
    //システムNoを条件に未削除の組み合わせ件数を取得する
    String Q_SET_GET_BY_SYS_NO_COUNT = ENTITY_SET + ".countSetBySysNo";
    String Q_SET_GET_BY_SYS_NO_COUNT_DEF = "SELECT COUNT(s) "
                                       + "FROM Set AS s "
                                       + "WHERE s.delFlg = 0 AND s.sysNo = :"
                                       + JPQL_PARM_SYS_NO;
    //列Noを条件に未削除の組み合わせを取得する
    String Q_SET_GET_BY_COL_NO = ENTITY_SET + ".getSetByColNo";
    String Q_SET_GET_BY_COL_NO_DEF = "SELECT s "
                                      + "FROM Set AS s "
                                      + "WHERE s.delFlg = 0 AND s.colSetNo = :"
                                      + JPQL_PARM_COL_NO
                                      + " ORDER BY s.id DESC";
    //列Noを条件に未削除の組み合わせ件数を取得する
    String Q_SET_GET_BY_COL_NO_COUNT = ENTITY_SET + ".countSetByColNo";
    String Q_SET_GET_BY_COL_NO_COUNT_DEF = "SELECT COUNT(s) "
                                      + "FROM Set AS s "
                                      + "WHERE s.delFlg = 0 AND s.colSetNo = :"
                                      + JPQL_PARM_COL_NO;
    //行Noを条件に未削除の組み合わせを取得する
    String Q_SET_GET_BY_ROW_NO = ENTITY_SET + ".getSetByRowNo";
    String Q_SET_GET_BY_ROW_NO_DEF = "SELECT s "
                                      + "FROM Set AS s "
                                      + "WHERE s.delFlg = 0 AND s.rowSetNo = :"
                                      + JPQL_PARM_ROW_NO
                                      + " ORDER BY s.id DESC";
    //行Noを条件に未削除の組み合わせ件数を取得する
    String Q_SET_GET_BY_ROW_NO_COUNT = ENTITY_SET + ".countSetByRowNo";
    String Q_SET_GET_BY_ROW_NO_COUNT_DEF = "SELECT COUNT(s) "
                                      + "FROM Set AS s "
                                      + "WHERE s.delFlg = 0 AND s.rowSetNo = :"
                                      + JPQL_PARM_ROW_NO;
    //列と行を条件に未削除の組み合わせを取得する
    String Q_SET_GET_BY_COL_ROW = ENTITY_SET + ".getSetByColRow";
    String Q_SET_GET_BY_COL_ROW_DEF = "SELECT s "
                                      + "FROM Set AS s "
                                      + "WHERE s.delFlg = 0 "
                                      + "AND s.colSetNo = :" +JPQL_PARM_COL_NO
                                      + " AND s.rowSetNo = :" +JPQL_PARM_ROW_NO
                                      + " ORDER BY s.id DESC";
    //列と行を条件に未削除の組み合わせ件数を取得する
    String Q_SET_GET_BY_COL_ROW_COUNT = ENTITY_SET + ".countSetByColRow";
    String Q_SET_GET_BY_COL_ROW_COUNT_DEF = "SELECT COUNT(s) "
                                      + "FROM Set AS s "
                                      + "WHERE s.delFlg = 0"
                                      + " AND s.colSetNo = :" +JPQL_PARM_COL_NO
                                      + " AND s.rowSetNo = :" +JPQL_PARM_ROW_NO;

    //予約済みフラグを条件に未削除の組み合わせを取得する
    String Q_SET_GET_BY_RSV_FLG = ENTITY_SET + ".getSetByRsvFlg";
    String Q_SET_GET_BY_RSV_FLG_DEF = "SELECT s "
                                       + "FROM Set AS s "
                                       + "WHERE s.delFlg = 0 AND s.rsvFlg = :"
                                       + JPQL_PARM_RSV_FLG
                                       + " ORDER BY s.id DESC";
    //予約済みフラグを条件に未削除の組み合わせ件数を取得する
    String Q_SET_GET_BY_RSV_FLG_COUNT = ENTITY_SET + ".countSetByRsvFlg";
    String Q_SET_GET_BY_RSV_FLG_COUNT_DEF = "SELECT COUNT(s) "
                                       + "FROM Set AS s "
                                       + "WHERE s.delFlg = 0 AND s.rsvFlg = :"
                                       + JPQL_PARM_RSV_FLG;

}