package top.shiyana.gmall.sms.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author shiyana
 * @email shiyana@lcd.com
 * @date 2020-05-04 15:01:55
 */
@ApiModel
@Data
@TableName("undo_log")
public class UndoLogEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	@ApiModelProperty(name = "id",value = "")
	private Long id;
	/**
	 * 
	 */
	@ApiModelProperty(name = "branchId",value = "")
	private Long branchId;
	/**
	 * 
	 */
	@ApiModelProperty(name = "xid",value = "")
	private String xid;
	/**
	 * 
	 */
	@ApiModelProperty(name = "context",value = "")
	private String context;
	/**
	 * 
	 */
	@ApiModelProperty(name = "rollbackInfo",value = "")
	private String rollbackInfo;
	/**
	 * 
	 */
	@ApiModelProperty(name = "logStatus",value = "")
	private Integer logStatus;
	/**
	 * 
	 */
	@ApiModelProperty(name = "logCreated",value = "")
	private Date logCreated;
	/**
	 * 
	 */
	@ApiModelProperty(name = "logModified",value = "")
	private Date logModified;
	/**
	 * 
	 */
	@ApiModelProperty(name = "ext",value = "")
	private String ext;

}
