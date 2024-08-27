Function addlight%(arg0.rooms, arg1#, arg2#, arg3#, arg4%, arg5#, arg6%, arg7%, arg8%)
    Local local0%
    Local local1%
    Local local2%
    If (arg0 <> Null) Then
        For local0 = $00 To $1F Step $01
            If (arg0\Field16[local0] = $00) Then
                arg0\Field16[local0] = createlight(arg4, $00)
                lightrange(arg0\Field16[local0], arg5)
                lightcolor(arg0\Field16[local0], (Float arg6), (Float arg7), (Float arg8))
                positionentity(arg0\Field16[local0], arg1, arg2, arg3, $01)
                entityparent(arg0\Field16[local0], arg0\Field2, $01)
                arg0\Field17[local0] = (((Float ((arg6 + arg7) + arg8)) / 255.0) / 3.0)
                arg0\Field18[local0] = createsprite($00)
                positionentity(arg0\Field18[local0], arg1, arg2, arg3, $00)
                scalesprite(arg0\Field18[local0], 0.13, 0.13)
                entitytexture(arg0\Field18[local0], at\Field3[$00], $00, $00)
                entityblend(arg0\Field18[local0], $03)
                entityparent(arg0\Field18[local0], arg0\Field2, $01)
                arg0\Field30[local0] = createpivot($00)
                entityradius(arg0\Field30[local0], 0.05, 0.0)
                positionentity(arg0\Field30[local0], arg1, arg2, arg3, $00)
                entityparent(arg0\Field30[local0], arg0\Field2, $01)
                arg0\Field31[local0] = createsprite($00)
                positionentity(arg0\Field31[local0], arg1, arg2, arg3, $00)
                scalesprite(arg0\Field31[local0], 0.6, 0.6)
                entitytexture(arg0\Field31[local0], at\Field3[$02], $00, $00)
                entityblend(arg0\Field31[local0], $03)
                entityorder(arg0\Field31[local0], $FFFFFFFF)
                entitycolor(arg0\Field31[local0], (Float arg6), (Float arg7), (Float arg8))
                entityparent(arg0\Field31[local0], arg0\Field2, $01)
                entityfx(arg0\Field31[local0], $01)
                rotateentity(arg0\Field31[local0], 0.0, 0.0, (Float rand($168, $01)), $00)
                spriteviewmode(arg0\Field31[local0], $01)
                arg0\Field29[local0] = $01
                hideentity(arg0\Field31[local0])
                arg0\Field33[local0] = rand($01, $0A)
                arg0\Field40[local0] = (Float arg6)
                arg0\Field41[local0] = (Float arg7)
                arg0\Field42[local0] = (Float arg8)
                hideentity(arg0\Field16[local0])
                arg0\Field28 = (arg0\Field28 + $01)
                Return arg0\Field16[local0]
            EndIf
        Next
    Else
        local1 = createlight(arg4, $00)
        lightrange(local1, arg5)
        lightcolor(local1, (Float arg6), (Float arg7), (Float arg8))
        positionentity(local1, arg1, arg2, arg3, $01)
        local2 = createsprite($00)
        positionentity(local2, arg1, arg2, arg3, $00)
        scalesprite(local2, 0.13, 0.13)
        entitytexture(local2, at\Field3[$00], $00, $00)
        entityblend(local2, $03)
        Return local1
    EndIf
    Return $00
End Function
