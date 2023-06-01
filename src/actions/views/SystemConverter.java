package actions.views;

import java.util.ArrayList;
import java.util.List;

import models.System;

/**
 * 利用者データのDTOモデル⇔Viewモデルの変換を行うクラス
 *
 */
public class SystemConverter {

    /**
     * ViewモデルのインスタンスからDTOモデルのインスタンスを作成する
     * @param uv UserViewのインスタンス
     * @return Userのインスタンス
     */
    public static System toModel(SystemView sv) {

        return new System(
                sv.getId(),
                sv.getSysNo(),
                sv.getSysName(),
                sv.getSysLevel() ,
                sv.getInpUserId(),
                sv.getInpDate(),
                sv.getUpdUserId(),
                sv.getUpdDate(),
                sv.getDelFlg()
                        );
    }

    /**
     * DTOモデルのインスタンスからViewモデルのインスタンスを作成する
     * @param e Userのインスタンス
     * @return UserViewのインスタンス
     */
    public static SystemView toView(System s) {

        if(s == null) {
            return null;
        }

        return new SystemView(
                s.getId(),
                s.getSysNo(),
                s.getSysName(),
                s.getSysLevel() == null
                        ? null
                        : s.getSysLevel() ,
                s.getInpUserId(),
                s.getInpDate(),
                s.getUpdUserId(),
                s.getUpdDate(),
                s.getDelFlg()
                );
    }

    /**
     * DTOモデルのリストからViewモデルのリストを作成する
     * @param list DTOモデルのリスト
     * @return Viewモデルのリスト
     */
    public static List<SystemView> toViewList(List<System> list) {
        List<SystemView> svs = new ArrayList<>();

        for (System s : list) {
            svs.add(toView(s));
        }

        return svs;
    }

    /**
     * Viewモデルの全フィールドの内容をDTOモデルのフィールドにコピーする
     * @param e DTOモデル(コピー先)
     * @param uv Viewモデル(コピー元)
     */
    public static void copyViewToModel(System s, SystemView sv) {
        s.setId(sv.getId());
        s.setSysNo(sv.getSysNo());
        s.setSysName(sv.getSysName());
        s.setSysLevel(sv.getSysLevel());
        s.setInpDate(sv.getInpDate());
        s.setInpUserId(sv.getInpUserId());
        s.setUpdDate(sv.getUpdDate());
        s.setUpdUserId(sv.getUpdUserId());
        s.setDelFlg(sv.getDelFlg());

    }

}