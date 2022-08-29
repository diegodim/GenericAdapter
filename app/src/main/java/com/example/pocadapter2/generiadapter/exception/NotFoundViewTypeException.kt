package com.example.pocadapter2.generiadapter.exception

import java.lang.RuntimeException

class NotFoundViewTypeException(viewType: Int) :
    RuntimeException("Could not find the view type: $viewType")
