package rs.ac.bg.etf.pp1;

import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;

public class TabExtended extends Tab {
	
	public static final Struct boolType = new Struct(Struct.Bool);
	
	public static void init() {
		Tab.init();
		Scope universe = Tab.currentScope;
		universe.addToLocals(new Obj(Obj.Type, "bool", TabExtended.boolType));
	}
}
