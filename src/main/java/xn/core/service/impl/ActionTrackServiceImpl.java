package xn.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xn.core.mapper.portal.CoreUserMapper;
import xn.core.mapper.system.ActionTrackMapper;
import xn.core.model.system.ActionTrackModel;
import xn.core.service.IActionTrackService;

@Service("ActionTrackService")
public class ActionTrackServiceImpl extends BaseServiceImpl implements IActionTrackService {

    @Autowired
    private ActionTrackMapper actionTrackMapper;

    @Autowired
    private CoreUserMapper coreUserMapper;

    @Override
    public void saveGuestInfro(ActionTrackModel atm) {
        actionTrackMapper.insert(atm);
    }

    @Override
    public void eidtPassword(String password) {
        coreUserMapper.editPassword(getUserId(), password);
    }
}
