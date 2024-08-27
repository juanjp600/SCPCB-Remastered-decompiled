Function graphics3dext%(arg0%, arg1%, arg2%, arg3%)
    graphics3d(arg0, arg1, arg2, arg3)
    initfastresize()
    antialias(getiniint("options.ini", "options", "antialias", $00))
    Return $00
End Function
