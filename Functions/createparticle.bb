Function createparticle.particles(arg0#, arg1#, arg2#, arg3%, arg4#, arg5#, arg6%)
    Local local0.particles
    Local local2%
    local0 = (New particles)
    local0\Field16 = (Float arg6)
    local0\Field0 = createsprite($00)
    positionentity(local0\Field0, arg0, arg1, arg2, $01)
    entitytexture(local0\Field0, at\Field2[arg3], $00, $00)
    rotateentity(local0\Field0, 0.0, 0.0, rnd(360.0, 0.0), $00)
    entityfx(local0\Field0, $09)
    spriteviewmode(local0\Field0, $03)
    Select arg3
        Case $00,$05,$06
            entityblend(local0\Field0, $01)
        Case $01,$02,$03,$04,$07
            entityblend(local0\Field0, local2)
    End Select
    local0\Field1 = createpivot($00)
    positionentity(local0\Field1, arg0, arg1, arg2, $01)
    local0\Field2 = arg3
    local0\Field10 = (arg5 * 0.004)
    local0\Field3 = 255.0
    local0\Field4 = 255.0
    local0\Field5 = 255.0
    local0\Field6 = 1.0
    local0\Field7 = arg4
    scalesprite(local0\Field0, local0\Field7, local0\Field7)
    Return local0
    Return Null
End Function
