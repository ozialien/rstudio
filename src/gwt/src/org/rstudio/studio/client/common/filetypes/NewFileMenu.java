/*
 * NewFileMenu.java
 *
 * Copyright (C) 2009-11 by RStudio, Inc.
 *
 * This program is licensed to you under the terms of version 3 of the
 * GNU Affero General Public License. This program is distributed WITHOUT
 * ANY EXPRESS OR IMPLIED WARRANTY, INCLUDING THOSE OF NON-INFRINGEMENT,
 * MERCHANTABILITY OR FITNESS FOR A PARTICULAR PURPOSE. Please refer to the
 * AGPL (http://www.gnu.org/licenses/agpl-3.0.txt) for more details.
 *
 */
package org.rstudio.studio.client.common.filetypes;

import com.google.inject.Inject;
import org.rstudio.core.client.command.MenuCallback;
import org.rstudio.studio.client.RStudioGinjector;

import java.util.ArrayList;

public class NewFileMenu
{
   public NewFileMenu()
   {
      RStudioGinjector.INSTANCE.injectMembers(this);
   }

   public void execute(MenuCallback callback)
   {
      for (FileTypeCommands.CommandWithId cmd : fileTypeCommands_)
         callback.addCommand(cmd.commandId, cmd.command);
   }

   @Inject
   void initialize(FileTypeCommands fileTypeCommands)
   {
      fileTypeCommands_ = fileTypeCommands.commandsWithIds(FileTypeRegistry.R);
   }
   
   private ArrayList<FileTypeCommands.CommandWithId> fileTypeCommands_ =
         new ArrayList<FileTypeCommands.CommandWithId>();

}
