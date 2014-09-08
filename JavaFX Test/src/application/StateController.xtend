package application

import java.util.HashMap

class StateController {
	HashMap<String, String> stateValues
	static StateController instance = null

	protected new() {
		stateValues = newHashMap()
		stateValues.put("loginAttempt", "0")
		stateValues.put("authenticated", "false")
		stateValues.put("loginUsername", "")
	}

	static def getInstance() {
		if (instance == null) {
			instance = new StateController
		}
		return instance
	}

	def getStateValues() {
		return stateValues
	}
}
