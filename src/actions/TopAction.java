package actions;

import java.io.IOException;

import javax.servlet.ServletException;

import actions.views.UserView;
import constants.AttributeConst;
import constants.ForwardConst;

/**
 * トップページに関する処理を行うActionクラス
 *
 */
public class TopAction extends ActionBase {

    //private UserService service; //追記

    /**
     * indexメソッドを実行する
     */
    @Override
    public void process() throws ServletException, IOException {

        //service = new UserService();

        //メソッドを実行
        invoke();

        //service.close();

    }

    /**
     * 一覧画面を表示する
     */
    public void index() throws ServletException, IOException {

        //セッションからログイン中の利用者情報を取得
//        UserView loginUser = (UserView) getSessionScope(AttributeConst.LOGIN_USER);
//
//        //ログイン中の利用者が作成した書籍データを、指定されたページ数の一覧画面に表示する分取得する
//        int page = getPage();
//
//        List<BookView> books = service.getMinePerPage(loginUser, page);
//
//        //ログイン中の利用者が作成した書籍データの件数を取得
//        long mybooksCount = service.countAllMine(loginUser);
//
//        putRequestScope(AttributeConst.BOOKS, books); //取得した書籍データ
//        putRequestScope(AttributeConst.BOOKS_COUNT, mybooksCount); //ログイン中の利用者が作成した書籍の数
//        putRequestScope(AttributeConst.PAGE, page); //ページ数
//        putRequestScope(AttributeConst.MAX_ROW, JpaConst.ROW_PER_PAGE); //1ページに表示するレコードの数

        //セッションにフラッシュメッセージが設定されている場合はリクエストスコープに移し替え、セッションからは削除する
        String flush = getSessionScope(AttributeConst.FLUSH);
        if (flush != null) {
            putRequestScope(AttributeConst.FLUSH, flush);
            removeSessionScope(AttributeConst.FLUSH);
        }

      //セッションからログイン中の利用者情報を取得
      UserView loginUser = (UserView) getSessionScope(AttributeConst.LOGIN_USER);

      if(loginUser != null) {
          putRequestScope(AttributeConst.USER, loginUser); //取得した書籍データ
      }

        //一覧画面を表示
        forward(ForwardConst.FW_TOP_INDEX);
    }

}