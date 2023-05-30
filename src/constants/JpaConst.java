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

    //利用者テーブル
    String TABLE_USER = "users"; //テーブル名
    //利用者テーブルカラム
    String USER_COL_ID = "resourse_id"; //リソースid
    String USER_COL_CODE = "user_id"; //ユーザーID
    String USER_COL_NAME = "user_name"; //ユーザー名
    String USER_COL_PASS = "password"; //パスワード
    String USER_COL_ADMIN_FLAG = "authority_ptn"; //管理者権限
    String USER_COL_COMMENT = "comment"; //コメント
    String USER_COL_INP_DATE = "inp_date"; //登録日時
    String USER_COL_INP_USER = "inp_user_id"; //登録ユーザーID
    String USER_COL_UPD_DATE = "upd_date"; //更新日時
    String USER_COL_UPD_USER = "upd_user_id"; //更新ユーザーID
    String USER_COL_DEL_FLG = "del_flg"; //削除フラグ

    int ROLE_ADMIN = 1; //管理者権限ON(管理者)
    int ROLE_GENERAL = 0; //管理者権限OFF(一般)
    int USER_DEL_TRUE = 1; //削除フラグON(削除済み)
    int USER_DEL_FALSE = 0; //削除フラグOFF(現役)

    //書籍情報テーブル
    String TABLE_BOOK = "books"; //テーブル名
    //書籍テーブルカラム
    String BOOK_COL_NO = "book_no"; //書籍No(リソースNo)
    String BOOK_COL_ID = "book_id"; //書籍ID
    String BOOK_COL_HOLDER = "holder"; //所持者のユーザーID
    String BOOK_COL_NAME = "book_name"; //書籍名(ユニーク)
    String BOOK_COL_GENRE = "genre_name"; //ジャンル名(ユニーク)
    String BOOK_COL_SERIES = "sereies_no"; //シリーズ番号(ユニーク)
    String BOOK_COL_READ = "read_flg"; //他者閲覧可能フラグ
    String BOOK_COL_COMMENT = "comment"; //補足事項
    String BOOK_COL_BUY_DATE = "buy_date"; //購入日
    String BOOK_COL_INP_DATE = "inp_date"; //登録日
    String BOOK_COL_INP_USER = "inp_user_id"; //登録した人のユーザーID
    String BOOK_COL_UPD_DATE = "upd_date"; //更新日
    String BOOK_COL_UPD_USER = "upd_user_id"; //更新した人のユーザーID
    String BOOK_COL_DEL_FLG = "del_flg"; //削除フラグ

    int READ_OK = 1; //他者閲覧可能
    int READ_NO = 0; //他者閲覧不可
    int BOOK_DEL_TRUE = 1; //削除フラグON(削除済み)
    int BOOK_DEL_FALSE = 0; //削除フラグOFF(現役)

    //Entity名
    String ENTITY_USER = "user"; //利用者
    String ENTITY_BOOK = "book"; //書籍

    //JPQL内パラメータ
    String JPQL_PARM_CODE = "user_id"; //ユーザーID
    String JPQL_PARM_PASSWORD = "password"; //パスワード
    String JPQL_PARM_USER = "user"; //利用者
    String JPQL_PARM_USER_NAME = "userName"; //利用者名
    String JPQL_PARM_BOOK_ID = "bookId"; //書籍ID
    String JPQL_PARM_BOOK_NAME = "bookName"; //書籍名
    String JPQL_PARM_BOOK_GENRE = "bookGenre"; //書籍ジャンル名
    String JPQL_PARM_SEREIES_NO = "sereiesNo"; //シリーズNO
    String JPQL_PARM_COMMENT = "comment";//コメント

    //NamedQueryの nameとquery
    //全ての利用者をユーザーidの降順(最新が上)に取得する
    String Q_USER_GET_ALL = ENTITY_USER + ".getAll"; //name
    String Q_USER_GET_ALL_DEF = "SELECT u "
                               + "FROM User AS u "
                               + "WHERE u.delFlg = '0'"
                               + "ORDER BY u.id DESC"; //query
    //全ての利用者の件数を取得する
    String Q_USER_COUNT = ENTITY_USER + ".count";
    String Q_USER_COUNT_DEF = "SELECT COUNT(u) "
                              + "FROM User AS u "
                              + "WHERE u.delFlg = '0'";
    //ユーザーIDとハッシュ化済パスワードを条件に未削除の利用者を取得する
    String Q_USER_GET_BY_CODE_AND_PASS = ENTITY_USER + ".getByUserIdAndPass";
    String Q_USER_GET_BY_CODE_AND_PASS_DEF = "SELECT u "
                                              + "FROM User AS u "
                                              + "WHERE u.delFlg = 0 AND u.userId = :"
                                              + JPQL_PARM_CODE
                                              + " AND u.password = :"
                                              + JPQL_PARM_PASSWORD;
    //指定したユーザーIDを保持する利用者の件数を取得する
    String Q_USER_COUNT_REGISTERED_BY_CODE = ENTITY_USER + ".countRegisteredByCode";
    String Q_USER_COUNT_REGISTERED_BY_CODE_DEF = "SELECT COUNT(u) "
                                                   + "FROM User AS u "
                                                   + "WHERE u.userId = :"
                                                   + JPQL_PARM_CODE
                                                   + " AND u.delFlg = 0";

    //条件検索で指定したユーザーIDを保持する利用者を取得する
    String Q_USER_SEARCH_BY_USER_ID = ENTITY_USER + ".searchByUserId";
    String Q_USER_SEARCH_BY_USER_ID_DEF = "SELECT u "
                                           + "FROM User AS u "
                                           + "WHERE u.userId LIKE :"
                                           + JPQL_PARM_CODE
                                           + " AND u.delFlg = 0";

  //条件検索で指定したユーザーID数を保持する利用者を取得する
    String Q_USER_SEARCH_BY_USER_ID_COUNT = ENTITY_USER + ".searchByUserIdCount";
    String Q_USER_SEARCH_BY_USER_ID_COUNT_DEF = "SELECT COUNT(u) "
                                           + "FROM User AS u "
                                           + "WHERE u.userId LIKE :"
                                           + JPQL_PARM_CODE
                                           + " AND u.delFlg = 0";

    //条件検索で指定したユーザー名を保持する利用者を取得する
    String Q_USER_SEARCH_BY_USER_NAME = ENTITY_USER + ".searchByUserName";
    String Q_USER_SEARCH_BY_USER_NAME_DEF = "SELECT u "
                                           + "FROM User AS u "
                                           + "WHERE u.userName LIKE :"
                                           + JPQL_PARM_USER_NAME
                                           + " AND u.delFlg = 0";

    //条件検索で指定したユーザー名数を保持する利用者を取得する
    String Q_USER_SEARCH_BY_USER_NAME_COUNT = ENTITY_USER + ".searchByUserNameCount";
    String Q_USER_SEARCH_BY_USER_NAME_COUNT_DEF = "SELECT COUNT(u) "
                                           + "FROM User AS u "
                                           + "WHERE u.userName LIKE :"
                                           + JPQL_PARM_USER_NAME
                                           + " AND u.delFlg = 0";

    //条件検索で指定したコメントを保持する利用者を取得する
    String Q_USER_SEARCH_BY_USER_COMMENT = ENTITY_USER + ".searchByComment";
    String Q_USER_SEARCH_BY_USER_COMMENT_DEF = "SELECT u "
                                           + "FROM User AS u "
                                           + "WHERE u.comment LIKE :"
                                           + JPQL_PARM_COMMENT
                                           + " AND u.delFlg = 0";

    //条件検索で指定したコメント数を保持する利用者を取得する
    String Q_USER_SEARCH_BY_USER_COMMENT_COUNT = ENTITY_USER + ".searchByCommentCount";
    String Q_USER_SEARCH_BY_USER_COMMENT_COUNT_DEF = "SELECT COUNT(u) "
                                           + "FROM User AS u "
                                           + "WHERE u.comment LIKE :"
                                           + JPQL_PARM_COMMENT
                                           + " AND u.delFlg = 0";

    //条件検索で指定した書籍名を保持する利用者を取得する
    String Q_BOOK_SEARCH_BY_BOOK_NAME = ENTITY_USER + ".searchByBookName";
    String Q_BOOK_SEARCH_BY_BOOK_NAME_DEF = "SELECT b "
                                           + "FROM Book AS b "
                                           + "WHERE b.bookName LIKE :"
                                           + JPQL_PARM_BOOK_NAME
                                           + " AND b.delFlg = 0";

  //条件検索で指定した書籍名数を保持する利用者を取得する
    String Q_BOOK_SEARCH_BY_BOOK_NAME_COUNT = ENTITY_USER + ".searchByBookNameCount";
    String Q_BOOK_SEARCH_BY_BOOK_NAME_COUNT_DEF = "SELECT COUNT(b) "
                                                    + "FROM Book AS b "
                                                    + "WHERE b.bookName LIKE :"
                                                    + JPQL_PARM_BOOK_NAME
                                                    + " AND b.delFlg = 0";

    //条件検索で指定したジャンル名を保持する利用者を取得する
    String Q_BOOK_SEARCH_BY_GENRE_NAME = ENTITY_USER + ".searchByGenreName";
    String Q_BOOK_SEARCH_BY_GENRE_NAME_DEF = "SELECT b "
                                           + "FROM Book AS b "
                                           + "WHERE b.bookGenre LIKE :"
                                           + JPQL_PARM_BOOK_GENRE
                                           + " AND b.delFlg = 0";

    //条件検索で指定したジャンル名数を保持する利用者を取得する
    String Q_BOOK_SEARCH_BY_GENRE_NAME_COUNT = ENTITY_USER + ".searchByGenreNameCount";
    String Q_BOOK_SEARCH_BY_GENRE_NAME_COUNT_DEF = "SELECT COUNT(b) "
                                                    + "FROM Book AS b "
                                                    + "WHERE b.bookGenre LIKE :"
                                                    + JPQL_PARM_BOOK_GENRE
                                                    + " AND b.delFlg = 0";

    //条件検索で指定したコメントを保持する利用者を取得する
    String Q_BOOK_SEARCH_BY_BOOK_COMMENT = ENTITY_USER + ".searchByBookComment";
    String Q_BOOK_SEARCH_BY_BOOK_COMMENT_DEF = "SELECT b "
                                           + "FROM Book AS b "
                                           + "WHERE b.bookComment LIKE :"
                                           + JPQL_PARM_COMMENT
                                           + " AND b.delFlg = 0";

    //条件検索で指定したコメント数を保持する利用者を取得する
    String Q_BOOK_SEARCH_BY_BOOK_COMMENT_COUNT = ENTITY_USER + ".searchByBookCommentCount";
    String Q_BOOK_SEARCH_BY_BOOK_COMMENT_COUNT_DEF = "SELECT COUNT(b) "
                                           + "FROM Book AS b "
                                           + "WHERE b.bookComment LIKE :"
                                           + JPQL_PARM_COMMENT
                                           + " AND b.delFlg = 0";

    //全ての書籍をidの降順に取得する
    String Q_BOOK_GET_ALL = ENTITY_BOOK + ".getAll";
    String Q_BOOK_GET_ALL_DEF = "SELECT b "
                                + "FROM Book AS b "
                                + "WHERE b.delFlg='0'"
                                + "ORDER BY b.id DESC";
    //全ての書籍の件数を取得する
    String Q_BOOK_COUNT = ENTITY_BOOK + ".count";
    String Q_BOOK_COUNT_DEF = "SELECT COUNT(b) "
                              + "FROM Book AS b "
                              + "WHERE b.delFlg='0'";
    //指定した利用者が所持している書籍情報を全件id(削除したものは除く)の降順で取得する
    String Q_BOOK_GET_ALL_MINE = ENTITY_BOOK + ".getAllMine";
    String Q_BOOK_GET_ALL_MINE_DEF = "SELECT b "
                                     + "FROM Book AS b "
                                     + "WHERE b.holderId = :"
                                     + JPQL_PARM_USER
                                     + " AND b.delFlg='0' "
                                     + "ORDER BY b.id DESC";
    //指定した利用者が所持している書籍の件数を取得する
    String Q_BOOK_COUNT_ALL_MINE = ENTITY_BOOK + ".countAllMine";
    String Q_BOOK_COUNT_ALL_MINE_DEF = "SELECT COUNT(b) "
                                       + "FROM Book AS b "
                                       + "WHERE b.holderId = :"
                                       + JPQL_PARM_USER
                                       + " AND b.delFlg='0' ";
    //指定した書籍IDが削除されていない件数を取得する
    String Q_BOOK_COUNT_DUPLICATION_ID = ENTITY_BOOK + ".countDuplicationId";
    String Q_BOOK_COUNT_DUPLICATION_ID_DEF = "SELECT COUNT(b) "
                                                   + "FROM Book AS b "
                                                   + "WHERE b.bookId = :"
                                                   + JPQL_PARM_BOOK_ID
                                                   + " AND b.delFlg = 0";
    //指定した書籍情報が削除されていない件数を取得する
    String Q_BOOK_COUNT_DUPLICATION_INFO = ENTITY_BOOK + ".countDuplicationInfo";
    String Q_BOOK_COUNT_DUPLICATION_INFO_DEF = "SELECT COUNT(b) "
                                                   + "FROM Book AS b "
                                                   + "WHERE b.bookName = :"
                                                   + JPQL_PARM_BOOK_NAME
                                                   + " AND b.bookGenre = :"
                                                   + JPQL_PARM_BOOK_GENRE
                                                   + " AND b.sereiesNo = :"
                                                   + JPQL_PARM_SEREIES_NO
                                                   + " AND b.delFlg = 0";

}