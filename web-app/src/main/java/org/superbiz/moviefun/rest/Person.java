/*
 *     Licensed to the Apache Software Foundation (ASF) under one or more
 *     contributor license agreements.  See the NOTICE file distributed with
 *     this work for additional information regarding copyright ownership.
 *     The ASF licenses this file to You under the Apache License, Version 2.0
 *     (the "License"); you may not use this file except in compliance with
 *     the License.  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */
package org.superbiz.moviefun.rest;

import org.eclipse.microprofile.jwt.Claim;
import org.superbiz.moviefun.utils.DecryptedValue;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class Person {

    @Inject
    @Claim("username")
    private String username;

    @Inject
    @Claim("email")
    private String email;

    @Inject
    @Claim("language")
    private String language;

    @Inject
    @DecryptedValue("creditCard")
    private String creditCard;

    @Inject
    @Claim("preferredGenre")
    private String preferredGenre;

    public Person() {
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public String getPreferredGenre() {
        return preferredGenre;
    }

    public String getLanguage() {
        return language;
    }
}
