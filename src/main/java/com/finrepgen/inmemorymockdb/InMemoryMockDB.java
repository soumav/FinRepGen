package com.finrepgen.inmemorymockdb;

import com.finrepgen.model.FinancialInfoInput;
import com.finrepgen.model.FinancialInfoReturn;

public class InMemoryMockDB {
	
	public static FinancialInfoInput finInfoInput;
	public static FinancialInfoReturn finInfoReturn;
	
	static {
		finInfoInput =  new FinancialInfoInput();
		finInfoReturn =  new FinancialInfoReturn();
	}

	public static FinancialInfoInput getFinInfoInput() {
		return finInfoInput;
	}

	public static void setFinInfoInput(FinancialInfoInput finInfoInput) {
		InMemoryMockDB.finInfoInput = finInfoInput;
	}

	public static FinancialInfoReturn getFinInfoReturn() {
		return finInfoReturn;
	}

	public static void setFinInfoReturn(FinancialInfoReturn finInfoReturn) {
		InMemoryMockDB.finInfoReturn = finInfoReturn;
	}
	

}
