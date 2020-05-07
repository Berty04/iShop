package by.htp.ishop.controller;

import java.util.HashMap;
import java.util.Map;

import by.htp.ishop.controller.command.Command;
import by.htp.ishop.controller.command.CommandName;
import by.htp.ishop.controller.command.impl.Register;
import by.htp.ishop.controller.command.impl.SignIn;

final class CommandProvider {
	private final Map<CommandName, Command> repository = new HashMap<>();

	CommandProvider() {
		repository.put(CommandName.AUTHORIZATION, new SignIn());
		repository.put(CommandName.REGISTRATION, new Register());
		//...
	}

	Command getCommand(String name) {
		CommandName commandName = null;
		Command command = null;
		try {
			commandName = CommandName.valueOf(name.toUpperCase());
			command = repository.get(commandName);
		} catch (IllegalArgumentException | NullPointerException e) {
			//write log
			command = repository.get(CommandName.WRONG_REQUEST);
		}
		return command;
	}
}