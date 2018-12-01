package top.kwseeker.springbootvalidator.config.validator;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

@GroupSequence({Default.class})         //校验GroupIdentityCheck组之前先校验Default.class组
public interface GroupIdentityCheck {
}
