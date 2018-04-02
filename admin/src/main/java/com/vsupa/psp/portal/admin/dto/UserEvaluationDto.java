package com.vsupa.psp.portal.admin.dto;

import com.vsupa.ecsp.user.vo.UserAccountBriefVo;
import com.vsupa.psp.park.vo.UserEvaluationVo;

/**
 * @author Maxwell.Lee
 * @date 2018-03-29 11:54
 * @since   1.0.0
 */
public class UserEvaluationDto extends UserEvaluationVo {

    private static final long serialVersionUID = 5227666544970317018L;
    /**
     * 用户昵称；
     */
    private String  userNickName;

    /**
     * 用户头像URL；
     */
    private String  userAvatarUrl;

    public UserEvaluationDto() {

    }

    public UserEvaluationDto(UserEvaluationVo evalVo, UserAccountBriefVo userVo) {
        super(evalVo);

        if (userVo != null) {
            this.userNickName = userVo.getNickName();
            this.userAvatarUrl = userVo.getAvatarImg();
        }
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getUserAvatarUrl() {
        return userAvatarUrl;
    }

    public void setUserAvatarUrl(String userAvatarUrl) {
        this.userAvatarUrl = userAvatarUrl;
    }

    @Override
    public String toString() {
        return "UserEvaluationDto{" +
                "userNickName='" + userNickName + '\'' +
                ", userAvatarUrl='" + userAvatarUrl + '\'' +
                "} " + super.toString();
    }
}
