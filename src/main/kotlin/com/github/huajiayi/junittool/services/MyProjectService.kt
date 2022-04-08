package com.github.huajiayi.junittool.services

import com.intellij.openapi.project.Project
import com.github.huajiayi.junittool.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
