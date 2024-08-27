Function addlightcones%(arg0.rooms)
    Local local0%
    Local local1.objects
    local1 = (First objects)
    For local0 = $00 To $1F Step $01
        If (arg0\Field16[local0] <> $00) Then
            arg0\Field43[local0] = copyentity(local1\Field7[$01], $00)
            scaleentity(arg0\Field43[local0], 0.01, 0.01, 0.01, $00)
            entitycolor(arg0\Field43[local0], arg0\Field40[local0], arg0\Field41[local0], arg0\Field42[local0])
            entityalpha(arg0\Field43[local0], 0.15)
            entityblend(arg0\Field43[local0], $03)
            positionentity(arg0\Field43[local0], entityx(arg0\Field30[local0], $01), entityy(arg0\Field30[local0], $01), entityz(arg0\Field30[local0], $01), $01)
            entityparent(arg0\Field43[local0], arg0\Field30[local0], $01)
            If (arg0\Field33[local0] > $04) Then
                arg0\Field44[local0] = createsprite($00)
                scalesprite(arg0\Field44[local0], 1.0, 1.0)
                entitytexture(arg0\Field44[local0], at\Field2[$08], $00, $00)
                spriteviewmode(arg0\Field44[local0], $02)
                entityfx(arg0\Field44[local0], $01)
                rotateentity(arg0\Field44[local0], -90.0, 0.0, 0.0, $00)
                entityblend(arg0\Field44[local0], $03)
                entityalpha(arg0\Field44[local0], 1.0)
                positionentity(arg0\Field44[local0], entityx(arg0\Field30[local0], $01), (entityy(arg0\Field30[local0], $01) + 0.05), entityz(arg0\Field30[local0], $01), $01)
                entityparent(arg0\Field44[local0], arg0\Field30[local0], $01)
            EndIf
        EndIf
    Next
    Return $00
End Function
