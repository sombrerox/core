/*
 * JBoss, Home of Professional Open Source
 * Copyright 2014, Red Hat, Inc., and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.weld.environment.servlet.logging;

import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;
import org.jboss.logging.annotations.Cause;
import org.jboss.logging.annotations.LogMessage;
import org.jboss.logging.annotations.Message;
import org.jboss.logging.annotations.MessageLogger;
import org.jboss.weld.environment.logging.WeldEnvironmentLogger;

/**
 *
 * Message IDs: 001100 - 001199
 *
 * @author Kirill Gaevskii
 *
*/
@MessageLogger(projectCode = WeldEnvironmentLogger.WELD_ENV_PROJECT_CODE)
public interface TomcatLogger extends WeldEnvironmentLogger {
    TomcatLogger LOG = Logger.getMessageLogger(TomcatLogger.class, Category.TOMCAT.getName());

    @LogMessage(level = Level.INFO)
    @Message(id = 1100, value = "Tomcat 7+ detected, CDI injection will be available in Servlets, Filters and Listeners.")
    void allInjectionsAvailable();

    @LogMessage(level = Level.INFO)
    @Message(id = 1101, value = "Tomcat 7+ detected, CDI injection will be available in Servlets and Filters. Injection into Listeners is not supported.")
    void listenersInjectionsNotAvailable();

    @LogMessage(level = Level.ERROR)
    @Message(id = 1102, value = "Unable to replace Tomcat 7 AnnotationProcessor. CDI injection will not be available in Servlets, Filters, or Listeners.")
    void unableToReplaceTomcat(@Cause Throwable cause);
}