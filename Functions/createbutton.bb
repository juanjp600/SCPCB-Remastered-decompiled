Function createbutton%(arg0#, arg1#, arg2#, arg3#, arg4#, arg5#, arg6%)
    Local local0.objects
    Local local1%
    local0 = (First objects)
    local1 = copyentity(local0\Field4[arg6], $00)
    scaleentity(local1, 0.03, 0.03, 0.03, $00)
    positionentity(local1, arg0, arg1, arg2, $00)
    rotateentity(local1, arg3, arg4, arg5, $00)
    entitypickmode(local1, $02, $01)
    Return local1
    Return $00
End Function
