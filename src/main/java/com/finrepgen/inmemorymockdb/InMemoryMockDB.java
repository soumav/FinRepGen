package com.finrepgen.inmemorymockdb;

import java.util.ArrayList;
import java.util.List;

import com.finrepgen.model.FinancialInfoInput;
import com.finrepgen.model.FinancialInfoReturn;
import com.finrepgen.model.User;

public class InMemoryMockDB {
	
	public static FinancialInfoInput finInfoInput;
	public static List<User> updtUsers;
	public static FinancialInfoReturn finInfoReturn;
	
	static {
		finInfoInput =  new FinancialInfoInput();
		updtUsers = new ArrayList<>();
		finInfoReturn =  new FinancialInfoReturn();
	}

	public static FinancialInfoInput getFinInfoInput() {
		return finInfoInput;
	}

	public static void setFinInfoInput(FinancialInfoInput finInfoInput) {
		InMemoryMockDB.finInfoInput = finInfoInput;
	}

	public static List<User> getUpdtUsers() {
		return updtUsers;
	}

	public static void setUpdtUsers(List<User> updtUsers) {
		InMemoryMockDB.updtUsers = updtUsers;
	}

	public static FinancialInfoReturn getFinInfoReturn() {
		return finInfoReturn;
	}

	public static void setFinInfoReturn(FinancialInfoReturn finInfoReturn) {
		InMemoryMockDB.finInfoReturn = finInfoReturn;
	}
	

}
