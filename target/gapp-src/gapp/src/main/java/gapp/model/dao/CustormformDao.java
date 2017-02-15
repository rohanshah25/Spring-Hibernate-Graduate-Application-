package gapp.model.dao;
import java.util.List;
import gapp.model.CustomField;



	public interface CustormformDao {
		
		public List<CustomField> listCustomfield();
		public CustomField getCustomformById(int controlid);
		public List<CustomField> getCustomFormByProgram(int programid);

	}



