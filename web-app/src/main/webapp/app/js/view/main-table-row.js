/**
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

(function () {
    'use strict';

    var deps = ['app/js/templates', 'backbone'];
    define(deps, function (templates, Backbone) {

        var View = Backbone.View.extend({
            initialize: function(options){
                this.options = options || {};
            },
            tagName: 'tr',
            events: {
                'click .ux-delete-row': function (evt) {
                    evt.preventDefault();
                    var me = this;
                    me.trigger('delete', {
                        model: me.model
                    });
                },
                'click .ux-edit-row': function (evt) {
                    evt.preventDefault();
                    var me = this;
                    me.trigger('edit', {
                        model: me.model
                    });
                },
                'click .ux-goto-movie': function (evt) {
                    evt.preventDefault();
                    var me = this;
                    me.trigger('movie', {
                        model: me.model
                    });
                }
            },

            render: function () {
                var me = this;
                if (!this.options.isRendered) {
                    me.$el.empty();
                    me.$el.append(templates.getValue('main-table-row', {
                        title: me.model.get('title'),
                        director: me.model.get('director'),
                        genre: me.model.get('genre'),
                        rating: me.model.get('rating'),
                        year: me.model.get('year'),
                        id: me.model.get('id')
                    }));
                    me.options.isRendered = true;
                }
                return this;
            }
        });
        return View;
    });
}());
