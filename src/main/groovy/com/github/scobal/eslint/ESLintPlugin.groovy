/**
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
 */
package com.github.scobal.eslint

import org.gradle.api.Plugin
import org.gradle.api.Project

class ESLintPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {

        def esLintPluginConvention = new ESLintPluginConvention(project)
        project.convention.plugins.eslint = esLintPluginConvention

        project.task('eslint') {
            doLast {
                project.exec {
                    executable esLintPluginConvention.getExecutable()
                    args esLintPluginConvention.getArguments()
                }
            }
        }

    }

}

