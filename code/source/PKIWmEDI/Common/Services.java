package PKIWmEDI.Common;

// -----( IS Java Code Template v1.2

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.text.DecimalFormat;
import java.math.*;
// --- <<IS-END-IMPORTS>> ---

public final class Services

{
	// ---( internal utility methods )---

	final static Services _instance = new Services();

	static Services _newInstance() { return new Services(); }

	static Services _cast(Object o) { return (Services)o; }

	// ---( server methods )---




	public static final void trimZeroes (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(trimZeroes)>> ---
		// @sigtype java 3.5
		// [i] field:0:required number
		// [o] field:0:required trimmedNumber
		
			IDataCursor idcPipeline = pipeline.getCursor();
			if (!idcPipeline.first("number"))
			{
				throw new ServiceException("input number was null!");
			}
		
			String strNumber = (String)idcPipeline.getValue();
			double dblNumber = Double.parseDouble(strNumber);
		
			DecimalFormat df = new DecimalFormat("#");
			
		
		//	idcPipeline.insertAfter("trimmedNumber", Double.toString(dblNumber));
			idcPipeline.insertAfter("trimmedNumber", df.format(dblNumber));
		
			idcPipeline.destroy();
		// --- <<IS-END>> ---

                
	}
}

