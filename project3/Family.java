
import java.util.List;

public class Family {
	
	private String ID;
	private String married;
	private String divorced;
	private String husbandID;
	private String husbandName;
	private String wifeID;
	private String wifeName;
	private List<String> children;
	
	public String getID() {
		return ID;
	}
	public String getMarried() {
		return married;
	}
	public String getDivorced() {
		return divorced;
	}
	public String getHusbandID() {
		return husbandID;
	}
	public String getHusbandName() {
		return husbandName;
	}
	public String getWifeID() {
		return wifeID;
	}
	public String getWifeName() {
		return wifeName;
	}
	public List<String> getChildren() {
		return children;
	}
	
	// mutators
	public void setID(String ID) {
		this.ID = ID;
	}
	public void setMarried(String married) {
		this.married = married;
	}
	public void setDivorced(String divorced) {
		this.divorced = divorced;
	}
	public void setHusbandId(String husbandID) {
		this.husbandID = husbandID;
	}
	public void setHusbandName(String husbandName) {
		this.husbandName = husbandName;
	}
	public void setWifeId(String wifeID) {
		this.wifeID = wifeID;
	}
	public void setWifeName(String wifeName) {
		this.wifeName = wifeName;
	}
	public void setChildren(List<String> children) {
		this.children = children;
	}

}