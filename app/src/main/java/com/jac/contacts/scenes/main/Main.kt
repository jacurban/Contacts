package com.jac.contacts.scenes.main

import com.jac.contacts.scenes.Scene

interface Main {
    interface View: Scene.View {}
    interface Presenter: Scene.Presenter{}
}