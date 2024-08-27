Function initloadgame%()
    Local local0.doors
    Local local1.securitycams
    Local local2.roomtemplates
    Local local3.events
    Local local4.fonts
    Local local5.fps_settings
    Local local6%
    Local local7%
    Local local8#
    Local local9#
    Local local10.chunk
    local4 = (First fonts)
    local5 = (First fps_settings)
    drawloading($50, $00)
    For local0 = Each doors
        entityparent(local0\Field0, $00, $01)
        If (local0\Field1 <> $00) Then
            entityparent(local0\Field1, $00, $01)
        EndIf
        If (local0\Field2 <> $00) Then
            entityparent(local0\Field2, $00, $01)
        EndIf
        If (local0\Field3[$00] <> $00) Then
            entityparent(local0\Field3[$00], $00, $01)
        EndIf
        If (local0\Field3[$01] <> $00) Then
            entityparent(local0\Field3[$01], $00, $01)
        EndIf
    Next
    For local1 = Each securitycams
        local1\Field11 = (entityyaw(local1\Field0, $00) + local1\Field11)
        entityparent(local1\Field0, $00, $01)
    Next
    resetentity(collider)
    drawloading($5A, $00)
    movemouse(viewport_center_x, viewport_center_y)
    aasetfont(local4\Field0[$00])
    hidepointer()
    blinktimer = blinkfreq
    stamina = 100.0
    For local2 = Each roomtemplates
        If (local2\Field0 <> $00) Then
            freeentity(local2\Field0)
            local2\Field0 = $00
        EndIf
    Next
    dropspeed = 0.0
    For local3 = Each events
        If (local3\Field0 = "dimension1499") Then
            If (2.0 = local3\Field2) Then
                drawloading($5B, $00)
                local3\Field1\Field19[$00] = createplane($01, $00)
                local6 = loadtexture_strict(scpmodding_processfilepath("GFX\map\dimension1499\grit3.jpg"), $01)
                entitytexture(local3\Field1\Field19[$00], local6, $00, $00)
                freetexture(local6)
                positionentity(local3\Field1\Field19[$00], 0.0, entityy(local3\Field1\Field2, $00), 0.0, $00)
                entitytype(local3\Field1\Field19[$00], $01, $00)
                drawloading($5C, $00)
                i_1499\Field8 = sky_createsky(scpmodding_processfilepath("GFX\map\sky\1499sky"), $00)
                drawloading($5D, $00)
                For local7 = $01 To $0F Step $01
                    local3\Field1\Field19[local7] = loadmesh_strict(scpmodding_processfilepath((("GFX\map\dimension1499\1499object" + (Str local7)) + ".b3d")), $00)
                    hideentity(local3\Field1\Field19[local7])
                Next
                drawloading($60, $00)
                createchunkparts(local3\Field1)
                drawloading($61, $00)
                local8 = entityx(local3\Field1\Field2, $00)
                local9 = entityz(local3\Field1\Field2, $00)
                For local7 = $FFFFFFFE To $02 Step $02
                    local10 = createchunk($FFFFFFFF, (((Float local7) * 2.5) * local8), entityy(local3\Field1\Field2, $00), local9, $00)
                Next
                drawloading($62, $00)
                updatechunks(local3\Field1, $0F, $00)
                Exit
            EndIf
        EndIf
    Next
    freetexturecache()
    drawloading($64, $00)
    local5\Field1 = millisecs()
    local5\Field3[$00] = 0.0
    resetinput()
    Return $00
End Function
