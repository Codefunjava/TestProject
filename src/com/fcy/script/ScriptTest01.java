package com.fcy.script;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class ScriptTest01 {
	public static void main(String[] args) throws Exception {
		ScriptEngineManager sem = new ScriptEngineManager();
		ScriptEngine engine = sem.getEngineByName("javascript");
		engine.put("msg","javax.script.ScriptEngine");
		
		String str = "var user = {name:'zhangsan',age:18,schools:'广东工业大学'};";
		str += "println(user.name);";
		engine.eval(str);
		
		engine.eval("msg = 'you are a good man!';");
		System.out.println(engine.get("msg"));
		
		engine.eval("function add(a,b){var sum = a + b; return sum;}");
		Invocable jsInvoke = (Invocable) engine;
		Object result = jsInvoke.invokeFunction("add", new Object[]{20,13});
		System.out.println(result);
		
		
	}
}
