package actions.views;

import java.util.ArrayList;
import java.util.List;

import models.User;

/**
 * 利用者データのDTOモデル⇔Viewモデルの変換を行うクラス
 *
 */
public class UserConverter {

    /**
     * ViewモデルのインスタンスからDTOモデルのインスタンスを作成する
     * @param uv UserViewのインスタンス
     * @return Userのインスタンス
     */
    public static User toModel(UserView uv) {

        return new User(
                uv.getId(),
                uv.getUserId(),
                uv.getUserName(),
                uv.getPassword(),
                uv.getSysLevel() ,
                uv.getMenuLevel(),
                uv.getInpUserId(),
                uv.getInpDate(),
                uv.getUpdUserId(),
                uv.getUpdDate(),
                uv.getDelFlg()
                        );
    }

    /**
     * DTOモデルのインスタンスからViewモデルのインスタンスを作成する
     * @param e Userのインスタンス
     * @return UserViewのインスタンス
     */
    public static UserView toView(User u) {

        if(u == null) {
            return null;
        }

        return new UserView(
                u.getId(),
                u.getUserId(),
                u.getUserName(),
                u.getPassword(),
                u.getSysLevel() == null
                        ? null
                        : u.getSysLevel() ,
                u.getMenuLevel() == null
                        ? null
                        : u.getMenuLevel() ,
                u.getInpDate(),
                u.getInpUserId(),
                u.getUpdDate(),
                u.getUpdUserId(),
                u.getDelFlg()
                );
    }

    /**
     * DTOモデルのリストからViewモデルのリストを作成する
     * @param list DTOモデルのリスト
     * @return Viewモデルのリスト
     */
    public static List<UserView> toViewList(List<User> list) {
        List<UserView> uvs = new ArrayList<>();

        for (User u : list) {
            uvs.add(toView(u));
        }

        return uvs;
    }

    /**
     * Viewモデルの全フィールドの内容をDTOモデルのフィールドにコピーする
     * @param e DTOモデル(コピー先)
     * @param uv Viewモデル(コピー元)
     */
    public static void copyViewToModel(User u, UserView uv) {
        u.setId(uv.getId());
        u.setUserId(uv.getUserId());
        u.setUserName(uv.getUserName());
        u.setPassword(uv.getPassword());
        u.setSysLevel(uv.getSysLevel());
        u.setMenuLevel(uv.getMenuLevel());
        u.setInpDate(uv.getInpDate());
        u.setInpUserId(uv.getInpUserId());
        u.setUpdDate(uv.getUpdDate());
        u.setUpdUserId(uv.getUpdUserId());
        u.setDelFlg(uv.getDelFlg());

    }

}