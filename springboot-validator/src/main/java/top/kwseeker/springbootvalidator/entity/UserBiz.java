package top.kwseeker.springbootvalidator.entity;

import org.hibernate.validator.constraints.Length;
import top.kwseeker.springbootvalidator.config.validator.GroupIdentityCheck;
import top.kwseeker.springbootvalidator.config.validator.GroupStudentCheck;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UserBiz {

    //默认分组 Default.class
    @NotNull
    private Integer userId;

    //实名认证校验组
    @Pattern(regexp = "(^[0-9a-zA-Z]{2,16}$)", groups = GroupIdentityCheck.class)
    private String trueName;

    @Pattern(regexp = "(^[0-9]{2}$)", groups = GroupIdentityCheck.class)
    private String cardCat;

    @Pattern(regexp = "(^[0-9]{17}[0-9a-zA-Z]$)", groups = GroupIdentityCheck.class)
    private String cardNo;

    //学生认证校验组
    @Pattern(regexp = "(^[0-9a-zA-Z]{2,16}$)", groups = GroupStudentCheck.class)
    private String studentName;

    @Pattern(regexp = "(^[0-9]{8,16}$)", groups = GroupStudentCheck.class)
    private String studentNo;

    @NotBlank(groups = GroupStudentCheck.class)
    @Length(max = 400, groups = GroupStudentCheck.class)
    private String studentPicurl;



    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getCardCat() {
        return cardCat;
    }

    public void setCardCat(String cardCat) {
        this.cardCat = cardCat;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getStudentPicurl() {
        return studentPicurl;
    }

    public void setStudentPicurl(String studentPicurl) {
        this.studentPicurl = studentPicurl;
    }

    @Override
    public String toString() {
        return "UserBiz{" +
                "userId=" + userId +
                ", trueName='" + trueName + '\'' +
                ", cardCat='" + cardCat + '\'' +
                ", cardNo='" + cardNo + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentNo='" + studentNo + '\'' +
                ", studentPicurl='" + studentPicurl + '\'' +
                '}';
    }
}
