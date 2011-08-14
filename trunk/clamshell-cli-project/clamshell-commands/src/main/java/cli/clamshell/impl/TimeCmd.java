/*
 * #%L
 * clamshell-commands
 * %%
 * Copyright (C) 2011 ClamShell-Cli
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package cli.clamshell.impl;

import cli.clamshell.api.Command;
import cli.clamshell.api.Context;
import cli.clamshell.api.IOConsole;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

/**
 * This class implements the Command interface to return the current time.
 * @author vladimir.vivien
 */
public class TimeCmd implements Command {
    private static final String ACTION_NAME = "time";

    @Override
    public Object execute(Context ctx) {
        IOConsole console = ctx.getIoConsole();
        console.writeOutput(String.format("%n%s%n%n",new Date().toString()));
        return null;
    }

    @Override
    public void plug(Context plug) {
        // no load-time setup needed
    }
    
    @Override
    public Command.Descriptor getDescriptor(){
        return new Command.Descriptor() {
            @Override
            public String getName() {
                return ACTION_NAME;
            }

            @Override
            public String getDescription() {
               return "Prints current date/time";
            }

            @Override
            public String getUsage() {
                return "Type 'time'";
            }

            @Override
            public Map<String, String> getArgsDescription() {
                return Collections.emptyMap();
            }
        };
    }
    
}