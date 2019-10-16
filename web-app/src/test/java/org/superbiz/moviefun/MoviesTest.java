/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.superbiz.moviefun;

import org.apache.cxf.feature.LoggingFeature;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.johnzon.jaxrs.JohnzonProvider;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.ClassLoaderAsset;
import org.jboss.shrinkwrap.api.asset.StringAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.superbiz.moviefun.rest.ApplicationConfig;
import org.superbiz.moviefun.rest.LoadDataResource;
import org.superbiz.moviefun.rest.MoviesMPJWTConfigurationProvider;
import org.superbiz.moviefun.rest.MoviesResource;
import org.superbiz.moviefun.utils.TokenUtil;
import org.superbiz.rest.GreetingResource;

import java.net.URL;
import java.util.Collection;
import java.util.HashMap;

import static java.util.Collections.singletonList;

@Ignore
@RunWith(Arquillian.class)
public class MoviesTest {

    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        final WebArchive webArchive = ShrinkWrap.create(WebArchive.class, "test.war")
                .addClasses(Movie.class, MoviesBean.class, MoviesTest.class, LoadDataResource.class)
                .addClasses(MoviesResource.class, GreetingResource.class, ApplicationConfig.class)
                .addClass(STSResource.class)
                .addClass(MoviesMPJWTConfigurationProvider.class)
                .addAsWebInfResource(new StringAsset("<beans/>"), "beans.xml")
                .addAsResource(new ClassLoaderAsset("META-INF/persistence.xml"), "META-INF/persistence.xml");

        System.out.println(webArchive.toString(true));

        return webArchive;
    }

    @ArquillianResource
    private URL base;

    @Test
    public void sthg() throws Exception {

        final WebClient webClient = WebClient
                .create(base.toExternalForm(), singletonList(new JohnzonProvider<>()), singletonList(new LoggingFeature()), null);

        webClient
                .reset()
                .path("/rest/greeting/")
                .get(String.class);

        final Collection<? extends Movie> movies = webClient
                .reset()
                .path("/rest/movies/")
                .header("Authorization", "Bearer " + token())
                .getCollection(Movie.class);

        System.out.println(movies);
    }

    private String token() throws Exception {
        return TokenUtil.generateTokenString("/Token1.json", null, new HashMap<>());
    }

}
