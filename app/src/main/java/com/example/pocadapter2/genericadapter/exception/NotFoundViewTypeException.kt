package com.example.pocadapter2.genericadapter.exception

import java.lang.RuntimeException

class NotFoundViewTypeException(viewType: Int) :
    RuntimeException("Could not find the view type: $viewType")
