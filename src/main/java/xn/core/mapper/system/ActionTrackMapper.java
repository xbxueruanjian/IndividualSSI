package xn.core.mapper.system;

import xn.core.mapper.base.IMapper;
import xn.core.model.system.ActionTrackModel;

/**
 * @Description:系统生成
 * @author 系统生成
 * @date :2016-5-9 20:09:46
 */
public interface ActionTrackMapper extends IMapper<ActionTrackModel> {
  
    /**
     * @Description: 添加来访信息
     * @author wch
     * @param atm
     */
    public void saveGuestInfro(ActionTrackModel atm);
}
