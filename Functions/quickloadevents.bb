Function quickloadevents%()
    Local local0.fps_settings
    Local local1.events
    Local local2.objects
    Local local3%
    Local local4%
    Local local5%
    Local local6%
    Local local7%
    Local local8.npcs
    Local local9%
    Local local10%
    Local local11#
    Local local12#
    Local local14%
    Local local15.chunk
    Local local16%
    Local local17.decals
    local0 = (First fps_settings)
    If (quickload_currevent = Null) Then
        quickloadpercent = $FFFFFFFF
        Return $00
    EndIf
    local1 = quickload_currevent
    local2 = (First objects)
    Select local1\Field0
        Case "room2sl"
            If (((0.0 = local1\Field2) And (local1\Field15 <> "")) <> 0) Then
                If (((local1\Field15 <> "") And (left(local1\Field15, $04) <> "load")) <> 0) Then
                    quickloadpercent = (quickloadpercent + $05)
                    If ((Int local1\Field15) > $09) Then
                        local1\Field15 = "load2"
                    Else
                        local1\Field15 = (Str ((Int local1\Field15) + $01))
                    EndIf
                ElseIf (local1\Field15 = "load2") Then
                    local14 = $00
                    If (local1\Field1\Field22[$00] = Null) Then
                        For local8 = Each npcs
                            If (local8\Field5 = $03) Then
                                local14 = $01
                                Exit
                            EndIf
                        Next
                        If (local14 = $00) Then
                            local1\Field1\Field22[$00] = createnpc($03, entityx(local1\Field1\Field19[$07], $01), (entityy(local1\Field1\Field19[$07], $01) + 5.0), entityz(local1\Field1\Field19[$07], $01))
                            local1\Field1\Field22[$00]\Field68 = $01
                            positionentity(local1\Field1\Field22[$00]\Field4, entityx(local1\Field1\Field19[$07], $01), (entityy(local1\Field1\Field19[$07], $01) + 5.0), entityz(local1\Field1\Field19[$07], $01), $00)
                            resetentity(local1\Field1\Field22[$00]\Field4)
                            rotateentity(local1\Field1\Field22[$00]\Field4, 0.0, (Float (local1\Field1\Field6 + $B4)), 0.0, $00)
                            local1\Field1\Field22[$00]\Field9 = 0.0
                            local1\Field1\Field22[$00]\Field12 = $02
                        EndIf
                    EndIf
                    quickloadpercent = $50
                    local1\Field15 = "load3"
                ElseIf (local1\Field15 = "load3") Then
                    local1\Field2 = 1.0
                    If (0.0 = local1\Field3) Then
                        local1\Field3 = -350.0
                    EndIf
                    quickloadpercent = $64
                EndIf
            EndIf
        Case "room2closets"
            If (0.0 = local1\Field2) Then
                If (local1\Field15 = "load0") Then
                    quickloadpercent = $0A
                    If (local1\Field1\Field22[$00] = Null) Then
                        local1\Field1\Field22[$00] = createnpc($12, entityx(local1\Field1\Field19[$00], $01), entityy(local1\Field1\Field19[$00], $01), entityz(local1\Field1\Field19[$00], $01))
                    EndIf
                    changenpctextureid(local1\Field1\Field22[$00], $11)
                    local1\Field15 = "load1"
                ElseIf (local1\Field15 = "load1") Then
                    quickloadpercent = $14
                    local1\Field1\Field22[$00]\Field16 = loadsound_strict(scpmodding_processfilepath("SFX\Room\Storeroom\Escape1.ogg"))
                    local1\Field15 = "load2"
                ElseIf (local1\Field15 = "load2") Then
                    quickloadpercent = $23
                    local1\Field1\Field22[$00]\Field17 = playsound2(local1\Field1\Field22[$00]\Field16, camera, local1\Field1\Field22[$00]\Field4, 12.0, 1.0)
                    local1\Field15 = "load3"
                ElseIf (local1\Field15 = "load3") Then
                    quickloadpercent = $37
                    If (local1\Field1\Field22[$01] = Null) Then
                        local1\Field1\Field22[$01] = createnpc($12, entityx(local1\Field1\Field19[$01], $01), entityy(local1\Field1\Field19[$01], $01), entityz(local1\Field1\Field19[$01], $01))
                    EndIf
                    changenpctextureid(local1\Field1\Field22[$01], $02)
                    local1\Field15 = "load4"
                ElseIf (local1\Field15 = "load4") Then
                    quickloadpercent = $50
                    local1\Field1\Field22[$01]\Field16 = loadsound_strict(scpmodding_processfilepath("SFX\Room\Storeroom\Escape2.ogg"))
                    local1\Field15 = "load5"
                ElseIf (local1\Field15 = "load5") Then
                    quickloadpercent = $64
                    pointentity(local1\Field1\Field22[$00]\Field4, local1\Field1\Field22[$01]\Field4, 0.0)
                    pointentity(local1\Field1\Field22[$01]\Field4, local1\Field1\Field22[$00]\Field4, 0.0)
                    local1\Field2 = 1.0
                EndIf
            EndIf
        Case "room3storage"
            If (local1\Field1\Field22[$00] = Null) Then
                local1\Field1\Field22[$00] = createnpc($0C, 0.0, 0.0, 0.0)
                quickloadpercent = $14
            ElseIf (local1\Field1\Field22[$01] = Null) Then
                local1\Field1\Field22[$01] = createnpc($0C, 0.0, 0.0, 0.0)
                quickloadpercent = $32
            ElseIf (local1\Field1\Field22[$02] = Null) Then
                local1\Field1\Field22[$02] = createnpc($0C, 0.0, 0.0, 0.0)
                quickloadpercent = $50
            ElseIf (local1\Field1\Field22[$03] = Null) Then
                local1\Field1\Field22[$03] = createnpc($0C, 0.0, 0.0, 0.0)
                quickloadpercent = $64
            ElseIf (quickloadpercent > $FFFFFFFF) Then
                quickloadpercent = $64
            EndIf
        Case "room049"
            If (0.0 = local1\Field2) Then
                If (local1\Field15 = "load0") Then
                    local8 = createnpc($04, entityx(local1\Field1\Field19[$04], $01), entityy(local1\Field1\Field19[$04], $01), entityz(local1\Field1\Field19[$04], $01))
                    pointentity(local8\Field4, local1\Field1\Field2, 0.0)
                    turnentity(local8\Field4, 0.0, 190.0, 0.0, $00)
                    quickloadpercent = $14
                    local1\Field15 = "load1"
                ElseIf (local1\Field15 = "load1") Then
                    local8 = createnpc($17, entityx(local1\Field1\Field19[$05], $01), entityy(local1\Field1\Field19[$05], $01), entityz(local1\Field1\Field19[$05], $01))
                    pointentity(local8\Field4, local1\Field1\Field2, 0.0)
                    turnentity(local8\Field4, 0.0, 0.0, 0.0, $00)
                    quickloadpercent = $28
                    local1\Field15 = "load2"
                ElseIf (local1\Field15 = "load2") Then
                    local8 = createnpc($04, entityx(local1\Field1\Field19[$0D], $01), entityy(local1\Field1\Field19[$0D], $01), entityz(local1\Field1\Field19[$0D], $01))
                    pointentity(local8\Field4, local1\Field1\Field2, 0.0)
                    turnentity(local8\Field4, 0.0, 20.0, 0.0, $00)
                    quickloadpercent = $3C
                    local1\Field15 = "load3"
                ElseIf (local1\Field15 = "load3") Then
                    For local8 = Each npcs
                        If (local8\Field5 = $03) Then
                            local1\Field1\Field22[$00] = local8
                            local1\Field1\Field22[$00]\Field9 = 2.0
                            local1\Field1\Field22[$00]\Field24 = 1.0
                            local1\Field1\Field22[$00]\Field68 = $01
                            positionentity(local1\Field1\Field22[$00]\Field4, entityx(local1\Field1\Field19[$04], $01), (entityy(local1\Field1\Field19[$04], $01) + 3.0), entityz(local1\Field1\Field19[$04], $01), $00)
                            resetentity(local1\Field1\Field22[$00]\Field4)
                            Exit
                        EndIf
                    Next
                    If (local1\Field1\Field22[$00] = Null) Then
                        local8 = createnpc($03, entityx(local1\Field1\Field19[$04], $01), (entityy(local1\Field1\Field19[$04], $01) + 3.0), entityz(local1\Field1\Field19[$04], $01))
                        pointentity(local8\Field4, local1\Field1\Field2, 0.0)
                        local8\Field9 = 2.0
                        local8\Field24 = 1.0
                        local8\Field68 = $01
                        local1\Field1\Field22[$00] = local8
                    EndIf
                    quickloadpercent = $64
                    local1\Field2 = 1.0
                EndIf
            EndIf
        Case "room205"
            If (((0.0 = local1\Field2) Or (local1\Field15 <> "loaddone")) <> 0) Then
                If (local1\Field15 = "load0") Then
                    local1\Field1\Field19[$03] = copyentity(local2\Field0[$23], $00)
                    quickloadpercent = $0A
                    local1\Field15 = "load1"
                ElseIf (local1\Field15 = "load1") Then
                    local1\Field1\Field19[$04] = copyentity(local2\Field0[$24], $00)
                    quickloadpercent = $14
                    local1\Field15 = "load2"
                ElseIf (local1\Field15 = "load2") Then
                    local1\Field1\Field19[$05] = copyentity(local2\Field0[$25], $00)
                    quickloadpercent = $1E
                    local1\Field15 = "load3"
                ElseIf (local1\Field15 = "load3") Then
                    local1\Field1\Field19[$06] = copyentity(local2\Field0[$26], $00)
                    quickloadpercent = $28
                    local1\Field15 = "load4"
                ElseIf (local1\Field15 = "load4") Then
                    quickloadpercent = $32
                    local1\Field15 = "load5"
                ElseIf (local1\Field15 = "load5") Then
                    For local10 = $03 To $06 Step $01
                        positionentity(local1\Field1\Field19[local10], entityx(local1\Field1\Field19[$00], $01), entityy(local1\Field1\Field19[$00], $01), entityz(local1\Field1\Field19[$00], $01), $01)
                        rotateentity(local1\Field1\Field19[local10], -90.0, entityyaw(local1\Field1\Field19[$00], $01), 0.0, $01)
                        scaleentity(local1\Field1\Field19[local10], 0.05, 0.05, 0.05, $01)
                    Next
                    quickloadpercent = $46
                    local1\Field15 = "load6"
                ElseIf (local1\Field15 = "load6") Then
                    hideentity(local1\Field1\Field19[$03])
                    hideentity(local1\Field1\Field19[$04])
                    hideentity(local1\Field1\Field19[$05])
                    quickloadpercent = $64
                    local1\Field15 = "loaddone"
                EndIf
            EndIf
        Case "room860"
            If (local1\Field15 = "load0") Then
                quickloadpercent = $0F
                forestnpc = createsprite($00)
                scalesprite(forestnpc, (1.0 / 3.904762), 0.75)
                spriteviewmode(forestnpc, $04)
                entityfx(forestnpc, $09)
                at\Field1[$02] = loadanimtexture("GFX\npcs\AgentIJ.AIJ", $03, $8C, $19A, $00, $04)
                forestnpcdata[$00] = 0.0
                entitytexture(forestnpc, at\Field1[$02], (Int forestnpcdata[$00]), $00)
                forestnpcdata[$01] = 0.0
                forestnpcdata[$02] = 0.0
                hideentity(forestnpc)
                local1\Field15 = "load1"
            ElseIf (local1\Field15 = "load1") Then
                quickloadpercent = $28
                local1\Field15 = "load2"
            ElseIf (local1\Field15 = "load2") Then
                quickloadpercent = $64
                If (local1\Field1\Field22[$00] = Null) Then
                    local1\Field1\Field22[$00] = createnpc($0B, 0.0, 0.0, 0.0)
                EndIf
                local1\Field15 = "loaddone"
            EndIf
        Case "room966"
            If (1.0 = local1\Field2) Then
                local1\Field3 = (local1\Field3 + local0\Field3[$00])
                If (30.0 < local1\Field3) Then
                    If (local1\Field15 = "") Then
                        createnpc($0D, entityx(local1\Field1\Field19[$00], $01), entityy(local1\Field1\Field19[$00], $01), entityz(local1\Field1\Field19[$00], $01))
                        quickloadpercent = $32
                        local1\Field15 = "load0"
                    ElseIf (local1\Field15 = "load0") Then
                        createnpc($0D, entityx(local1\Field1\Field19[$02], $01), entityy(local1\Field1\Field19[$02], $01), entityz(local1\Field1\Field19[$02], $01))
                        quickloadpercent = $64
                        local1\Field2 = 2.0
                    EndIf
                Else
                    quickloadpercent = (Int local1\Field3)
                EndIf
            EndIf
        Case "dimension1499"
            If (0.0 = local1\Field2) Then
                If (local1\Field15 = "load0") Then
                    quickloadpercent = $0A
                    local1\Field1\Field19[$00] = loadmesh_strict(scpmodding_processfilepath("GFX\map\dimension1499\1499plane.b3d"), $00)
                    hideentity(local1\Field1\Field19[$00])
                    local1\Field15 = "load1"
                ElseIf (local1\Field15 = "load1") Then
                    quickloadpercent = $1E
                    i_1499\Field8 = sky_createsky(scpmodding_processfilepath("GFX\map\sky\1499sky"), $00)
                    local1\Field15 = "1"
                ElseIf ((Int local1\Field15) < $10) Then
                    quickloadpercent = (quickloadpercent + $02)
                    local1\Field1\Field19[(Int local1\Field15)] = loadmesh_strict(scpmodding_processfilepath((("GFX\map\dimension1499\1499object" + (Str (Int local1\Field15))) + ".b3d")), $00)
                    hideentity(local1\Field1\Field19[(Int local1\Field15)])
                    local1\Field15 = (Str ((Int local1\Field15) + $01))
                ElseIf ((Int local1\Field15) = $10) Then
                    quickloadpercent = $5A
                    createchunkparts(local1\Field1)
                    local1\Field15 = "17"
                ElseIf ((Int local1\Field15) = $11) Then
                    quickloadpercent = $64
                    local11 = entityx(local1\Field1\Field2, $00)
                    local12 = entityz(local1\Field1\Field2, $00)
                    For local10 = $FFFFFFFE To $00 Step $02
                        local15 = createchunk($FFFFFFFF, (((Float local10) * 2.5) * local11), entityy(local1\Field1\Field2, $00), local12, $01)
                    Next
                    For local10 = $FFFFFFFE To $00 Step $02
                        local15 = createchunk($FFFFFFFF, (((Float local10) * 2.5) * local11), entityy(local1\Field1\Field2, $00), (local12 - 40.0), $01)
                    Next
                    local1\Field2 = 2.0
                    local1\Field15 = "18"
                EndIf
            EndIf
        Case "room457"
            If (local1\Field1\Field22[$00] = Null) Then
                local16 = rand($00, $04)
                local1\Field1\Field22[$00] = createnpc($19, entityx(local1\Field1\Field19[local16], $01), entityy(local1\Field1\Field19[local16], $01), entityz(local1\Field1\Field19[local16], $01))
                quickloadpercent = $64
            ElseIf (quickloadpercent > $FFFFFFFF) Then
                quickloadpercent = $64
            EndIf
        Case "room409"
            If (0.0 = local1\Field2) Then
                If (local1\Field15 = "load0") Then
                    local1\Field1\Field22[$00] = createnpc($12, entityx(local1\Field1\Field19[$00], $01), (entityy(local1\Field1\Field19[$00], $01) + 0.5), entityz(local1\Field1\Field19[$00], $01))
                    changenpctextureid(local1\Field1\Field22[$00], $0E)
                    setnpcframe(local1\Field1\Field22[$00], 19.0)
                    local1\Field1\Field22[$00]\Field9 = 8.0
                    turnentity(local1\Field1\Field22[$00]\Field4, 0.0, (Float (local1\Field1\Field6 + $168)), 0.0, $00)
                    local1\Field1\Field22[$00]\Field48 = $01
                    quickloadpercent = $1E
                    local1\Field15 = "load1"
                ElseIf (local1\Field15 = "load1") Then
                    local17 = createdecal($13, entityx(local1\Field1\Field19[$02], $01), (entityy(local1\Field1\Field19[$02], $01) + 0.01), entityz(local1\Field1\Field19[$02], $01), 90.0, (Float rand($168, $01)), 0.0)
                    local17\Field2 = 0.05
                    entityalpha(local17\Field0, 0.8)
                    quickloadpercent = $3C
                    local1\Field15 = "load2"
                ElseIf (local1\Field15 = "load2") Then
                    quickloadpercent = $64
                    local1\Field2 = 1.0
                EndIf
            EndIf
        Case "room009"
            If (0.0 = local1\Field5) Then
                If (local1\Field15 = "load0") Then
                    local1\Field1\Field22[$00] = createnpc($12, entityx(local1\Field1\Field19[$00], $01), entityy(local1\Field1\Field19[$00], $01), entityz(local1\Field1\Field19[$00], $01))
                    setnpcframe(local1\Field1\Field22[$00], 19.0)
                    local1\Field1\Field22[$00]\Field9 = 8.0
                    turnentity(local1\Field1\Field22[$00]\Field4, 0.0, (Float (local1\Field1\Field6 + $168)), 0.0, $00)
                    local1\Field1\Field22[$00]\Field48 = $01
                    quickloadpercent = $32
                    local1\Field15 = "load1"
                ElseIf (local1\Field15 = "load1") Then
                    quickloadpercent = $64
                    local1\Field5 = 1.0
                EndIf
            EndIf
    End Select
    Return $00
End Function
