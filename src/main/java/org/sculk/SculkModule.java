package org.sculk;


import com.google.inject.PrivateModule;
import com.google.inject.binder.AnnotatedBindingBuilder;
import lombok.RequiredArgsConstructor;
import org.sculk.event.EventManager;
import org.sculk.event.EventManagerInterface;

/*
 *   ____             _ _              __  __ ____
 *  / ___|  ___ _   _| | | __         |  \/  |  _ \
 *  \___ \ / __| | | | | |/ /  _____  | |\/| | |_) |
 *   ___) | (__| |_| | |   <  |_____| | |  | |  __/
 *  |____/ \___|\__,_|_|_|\_\         |_|  |_|_|
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * @author: SculkTeams
 * @link: http://www.sculkmp.org/
 */
@RequiredArgsConstructor
public class SculkModule extends PrivateModule {

    private final Server server;

    private <T>AnnotatedBindingBuilder<T> bindAndExpose(final Class<T> type) {
        this.expose(type);
        return this.bind(type);
    }

    @Override
    protected void configure() {
        this.bindAndExpose(Server.class).toInstance(this.server);
        this.bindAndExpose(EventManagerInterface.class).to(EventManager.class);
    }

}
