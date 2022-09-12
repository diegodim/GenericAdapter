package com.example.pocadapter2.genericadapter.exception

import java.lang.RuntimeException

internal class NotFoundViewTypeException(viewType: Int) :
    RuntimeException("Could not find the view type: $viewType")
