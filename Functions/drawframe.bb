Function drawframe%(arg0%, arg1%, arg2%, arg3%, arg4%, arg5%)
    color($FF, $FF, $FF)
    drawtiledimagerect(menuwhite, arg4, (arg1 Mod $100), 512.0, 512.0, arg0, arg1, arg2, arg3)
    drawtiledimagerect(menublack, arg5, (arg1 Mod $100), 512.0, 512.0, (Int ((3.0 * menuscale) + (Float arg0))), (Int ((3.0 * menuscale) + (Float arg1))), (Int ((Float arg2) - (6.0 * menuscale))), (Int ((Float arg3) - (6.0 * menuscale))))
    Return $00
End Function
