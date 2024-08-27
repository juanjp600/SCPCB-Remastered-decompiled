Function loadgame%(arg0$)
    Local local0$
    Local local1#
    Local local2#
    Local local3#
    Local local4%
    Local local5%
    Local local6$
    Local local7.rooms
    Local local8%
    Local local9.npcs
    Local local10.doors
    Local local11%
    Local local12%
    Local local13#
    Local local14#
    Local local15%
    Local local17%
    Local local18#
    Local local20.npcs
    Local local21%
    Local local22%
    Local local23%
    Local local24%
    Local local25%
    Local local26.roomtemplates
    Local local27%
    Local local28$
    Local local29#
    Local local30#
    Local local31#
    Local local32#
    Local local33%
    Local local34%
    Local local37%
    Local local38#
    Local local39%
    Local local40%
    Local local41#
    Local local42#
    Local local43#
    Local local44#
    Local local45%
    Local local46#
    Local local47%
    Local local48%
    Local local49.decals
    Local local50#
    Local local51#
    Local local52#
    Local local53.events
    Local local54.dummy1499
    Local local55.items
    Local local56$
    Local local57$
    Local local58$
    Local local59%
    Local local60%
    Local local61%
    Local local62%
    Local local63%
    Local local64.itemtemplates
    Local local65%
    Local local66.items
    Local local67%
    Local local68#
    Local local69.rooms
    Local local70#
    Local local71.rooms
    local0 = ""
    dropspeed = 0.0
    debughud = $00
    gamesaved = $01
    local11 = readfile((arg0 + "save.txt"))
    local6 = readstring(local11)
    local6 = readstring(local11)
    playtime = readint(local11)
    local1 = readfloat(local11)
    local2 = readfloat(local11)
    local3 = readfloat(local11)
    positionentity(collider, local1, (local2 + 0.05), local3, $00)
    resetentity(collider)
    hideentity(at\Field4[$05])
    hideentity(at\Field4[$08])
    hideentity(at\Field4[$09])
    local1 = readfloat(local11)
    local2 = readfloat(local11)
    local3 = readfloat(local11)
    positionentity(head, local1, (local2 + 0.05), local3, $00)
    resetentity(head)
    accesscode = (Int readstring(local11))
    local1 = readfloat(local11)
    local2 = readfloat(local11)
    rotateentity(collider, local1, local2, 0.0, $00)
    local6 = readstring(local11)
    local0 = local6
    blinktimer = readfloat(local11)
    blinkeffect = readfloat(local11)
    blinkeffecttimer = readfloat(local11)
    deathtimer = (Float readint(local11))
    blurtimer = (Float readint(local11))
    healtimer = readfloat(local11)
    crouch = readbyte(local11)
    stamina = readfloat(local11)
    staminaeffect = readfloat(local11)
    staminaeffecttimer = readfloat(local11)
    eyestuck = readfloat(local11)
    eyeirritation = readfloat(local11)
    injuries = readfloat(local11)
    bloodloss = readfloat(local11)
    previnjuries = readfloat(local11)
    prevbloodloss = readfloat(local11)
    deathmsg = readstring(local11)
    For local4 = $00 To $05 Step $01
        scp1025state[local4] = readfloat(local11)
    Next
    vomittimer = readfloat(local11)
    vomit = readbyte(local11)
    camerashaketimer = readfloat(local11)
    i_008\Field0 = readfloat(local11)
    i_447\Field0 = readbyte(local11)
    i_447\Field1 = readfloat(local11)
    i_447\Field2 = readbyte(local11)
    i_447\Field3 = readfloat(local11)
    i_447\Field4 = readbyte(local11)
    i_447\Field5 = readfloat(local11)
    usedmorphine = readbyte(local11)
    morphinetimer = readfloat(local11)
    morphinehealamount = readfloat(local11)
    i_409\Field0 = readfloat(local11)
    i_178\Field0 = readbyte(local11)
    i_215\Field0 = readbyte(local11)
    i_215\Field1 = readfloat(local11)
    i_215\Field2 = readfloat(local11)
    i_215\Field4 = readbyte(local11)
    i_1033ru\Field2 = readbyte(local11)
    i_1033ru\Field0 = readbyte(local11)
    i_1033ru\Field1 = readbyte(local11)
    i_1079\Field0 = readfloat(local11)
    i_1079\Field1 = readbyte(local11)
    i_1079\Field2 = readbyte(local11)
    i_1079\Field3 = readbyte(local11)
    i_207\Field0 = readfloat(local11)
    i_500\Field0 = readbyte(local11)
    i_402\Field0 = readbyte(local11)
    i_402\Field1 = readfloat(local11)
    i_357\Field0 = readfloat(local11)
    chancetospawn005 = readbyte(local11)
    mtf2timer = readfloat(local11)
    contained457 = readbyte(local11)
    gasmaskblurtimer = readfloat(local11)
    wearinghelmet = readbyte(local11)
    local12 = readbyte(local11)
    selecteddifficulty = difficulties(local12)
    If (local12 = $04) Then
        selecteddifficulty\Field3 = readbyte(local11)
        selecteddifficulty\Field2 = readbyte(local11)
        selecteddifficulty\Field4 = readbyte(local11)
        selecteddifficulty\Field5 = readbyte(local11)
        selecteddifficulty\Field11 = readbyte(local11)
        selecteddifficulty\Field10 = readbyte(local11)
    EndIf
    monitortimer = readfloat(local11)
    sanity = readfloat(local11)
    wearinggasmask = readbyte(local11)
    wearingvest = readbyte(local11)
    wearinghazmat = readbyte(local11)
    wearingnightvision = readbyte(local11)
    i_1499\Field0 = readbyte(local11)
    i_1499\Field1 = readfloat(local11)
    i_1499\Field2 = readfloat(local11)
    i_1499\Field3 = readfloat(local11)
    i_1499\Field5 = readfloat(local11)
    i_1499\Field6 = readfloat(local11)
    i_1499\Field7 = readfloat(local11)
    local13 = readfloat(local11)
    local14 = readfloat(local11)
    superman = readbyte(local11)
    supermantimer = readfloat(local11)
    lightson = readbyte(local11)
    randomseed = readstring(local11)
    secondarylighton = readfloat(local11)
    prevsecondarylighton = readfloat(local11)
    remotedooron = readbyte(local11)
    soundtransmission = readbyte(local11)
    contained106 = readbyte(local11)
    For local4 = $00 To $3A Step $01
        achievements(local4) = readbyte(local11)
    Next
    refineditems = readint(local11)
    mapwidth = readint(local11)
    mapheight = readint(local11)
    For local1 = 0.0 To (Float mapwidth) Step 1.0
        For local2 = 0.0 To (Float mapheight) Step 1.0
            maptemp((Int local1), (Int local2)) = readint(local11)
            mapfound((Int local1), (Int local2)) = readbyte(local11)
        Next
    Next
    If (readint(local11) <> $71) Then
        runtimeerror("Couldn't load the game, save file corrupted (error 2.5)")
    EndIf
    local5 = readint(local11)
    For local4 = $01 To local5 Step $01
        local15 = readbyte(local11)
        local1 = readfloat(local11)
        local2 = readfloat(local11)
        local3 = readfloat(local11)
        local9 = createnpc(local15, local1, local2, local3)
        Select local15
            Case $08
                curr173 = local9
            Case $07
                curr106 = local9
            Case $06
                curr096 = local9
            Case $0A
                curr5131 = local9
            Case $1A
                curr650 = local9
            Case $05
                curr066 = local9
        End Select
        local1 = readfloat(local11)
        local2 = readfloat(local11)
        local3 = readfloat(local11)
        rotateentity(local9\Field4, local1, local2, local3, $00)
        local9\Field9 = readfloat(local11)
        local9\Field10 = readfloat(local11)
        local9\Field11 = readfloat(local11)
        local9\Field12 = readint(local11)
        local9\Field76 = readint(local11)
        local9\Field24 = (Float readbyte(local11))
        local9\Field27 = readfloat(local11)
        local9\Field26 = readint(local11)
        local9\Field22 = (Float readint(local11))
        local9\Field15 = readfloat(local11)
        local9\Field25 = readfloat(local11)
        forcesetnpcid(local9, readint(local11))
        local9\Field32 = readint(local11)
        local9\Field33 = readfloat(local11)
        local9\Field34 = readfloat(local11)
        local9\Field35 = readfloat(local11)
        local9\Field23 = readstring(local11)
        If (local9\Field23 <> "") Then
            local17 = loadtexture_strict(local9\Field23, $01)
            entitytexture(local9\Field0, local17, $00, $00)
        EndIf
        local18 = readfloat(local11)
        Select local15
            Case $07,$12,$06,$14,$13,$03,$04,$11,$1A,$17,$1C,$19,$16,$02,$01,$1D
                setanimtime(local9\Field0, local18, $00)
        End Select
        local9\Field14 = local18
        local9\Field48 = readint(local11)
        local9\Field62 = readfloat(local11)
        local9\Field63 = readfloat(local11)
        local9\Field61 = readint(local11)
        local9\Field64 = readstring(local11)
        local9\Field65 = readfloat(local11)
        local9\Field66 = readfloat(local11)
        local9\Field67 = readfloat(local11)
        If (local9\Field64 <> "") Then
            freeentity(local9\Field0)
            local9\Field0 = loadanimmesh_strict(local9\Field64, $00)
            scaleentity(local9\Field0, local9\Field65, local9\Field66, local9\Field67, $00)
            setanimtime(local9\Field0, local18, $00)
        EndIf
        local9\Field69 = readint(local11)
        If (local9\Field69 > $00) Then
            changenpctextureid(local9, (local9\Field69 - $01))
            setanimtime(local9\Field0, local18, $00)
        EndIf
    Next
    For local9 = Each npcs
        If (local9\Field32 <> $00) Then
            For local20 = Each npcs
                If (local20 <> local9) Then
                    If (local20\Field6 = local9\Field32) Then
                        local9\Field31 = local20
                    EndIf
                EndIf
            Next
        EndIf
    Next
    mtftimer = readfloat(local11)
    For local4 = $00 To $06 Step $01
        local6 = readstring(local11)
        If (local6 <> "a") Then
            For local7 = Each rooms
                If (local7\Field7\Field10 = local6) Then
                    mtfrooms[local4] = local7
                    mtf2rooms[local4] = local7
                EndIf
            Next
        EndIf
        mtfroomstate[local4] = readint(local11)
        mtf2roomstate[local4] = readint(local11)
    Next
    If (readint(local11) <> $278) Then
        runtimeerror("Couldn't load the game, save file corrupted (error 1)")
    EndIf
    room2gw_brokendoor = readint(local11)
    room2gw_x = readfloat(local11)
    room2gw_z = readfloat(local11)
    If (local0 = modcompatiblenumber) Then
        i_zone\Field0[$00] = readbyte(local11)
        i_zone\Field0[$01] = readbyte(local11)
        i_zone\Field1 = readbyte(local11)
        i_zone\Field2 = readbyte(local11)
    EndIf
    local5 = readint(local11)
    For local4 = $01 To local5 Step $01
        local21 = readint(local11)
        local22 = readint(local11)
        local1 = readfloat(local11)
        local2 = readfloat(local11)
        local3 = readfloat(local11)
        local23 = readbyte(local11)
        local24 = readint(local11)
        local25 = readbyte(local11)
        local22 = (Int wrapangle((Float local22)))
        For local26 = Each roomtemplates
            If (local26\Field1 = local21) Then
                local7 = createroom(local24, local26\Field9, local1, local2, local3, local26\Field10)
                turnentity(local7\Field2, 0.0, (Float local22), 0.0, $00)
                local7\Field6 = local22
                local7\Field1 = local23
                Exit
            EndIf
        Next
        If (local25 = $01) Then
            playerroom = local7
        EndIf
        For local1 = 0.0 To 11.0 Step 1.0
            local8 = readint(local11)
            If (local8 > $00) Then
                For local9 = Each npcs
                    If (local9\Field6 = local8) Then
                        local7\Field22[(Int local1)] = local9
                        Exit
                    EndIf
                Next
            EndIf
        Next
        For local1 = 0.0 To 11.0 Step 1.0
            local8 = readbyte(local11)
            If (local8 = $02) Then
                Exit
            ElseIf (local8 = $01) Then
                rotateentity(local7\Field20[(Int local1)], 78.0, entityyaw(local7\Field20[(Int local1)], $00), 0.0, $00)
            Else
                rotateentity(local7\Field20[(Int local1)], -78.0, entityyaw(local7\Field20[(Int local1)], $00), 0.0, $00)
            EndIf
        Next
        If (readbyte(local11) = $01) Then
            If (local7\Field23 <> Null) Then
                For local1 = 0.0 To 18.0 Step 1.0
                    For local2 = 0.0 To 18.0 Step 1.0
                        If (local7\Field23\Field3[(Int ((local2 * 19.0) + local1))] <> $00) Then
                            freeentity(local7\Field23\Field3[(Int ((local2 * 19.0) + local1))])
                            local7\Field23\Field3[(Int ((local2 * 19.0) + local1))] = $00
                        EndIf
                        If (local7\Field23\Field4[(Int ((local2 * 19.0) + local1))] <> Null) Then
                            removewaypoint(local7\Field23\Field4[(Int ((local2 * 19.0) + local1))])
                            local7\Field23\Field4[(Int ((local2 * 19.0) + local1))] = Null
                        EndIf
                    Next
                Next
                For local1 = 0.0 To 5.0 Step 1.0
                    If (local7\Field23\Field2[(Int local1)] <> $00) Then
                        freeentity(local7\Field23\Field2[(Int local1)])
                        local7\Field23\Field2[(Int local1)] = $00
                    EndIf
                Next
                Delete local7\Field23
            EndIf
            local7\Field23 = (New grids)
            For local2 = 0.0 To 18.0 Step 1.0
                For local1 = 0.0 To 18.0 Step 1.0
                    local7\Field23\Field0[(Int ((local2 * 19.0) + local1))] = readbyte(local11)
                    local7\Field23\Field1[(Int ((local2 * 19.0) + local1))] = readbyte(local11)
                Next
            Next
        EndIf
        local27 = readbyte(local11)
        If (local27 > $00) Then
            If (local7\Field11 <> Null) Then
                destroyforest(local7\Field11)
            Else
                local7\Field11 = (New forest)
            EndIf
            For local2 = 0.0 To 9.0 Step 1.0
                local28 = ""
                For local1 = 0.0 To 9.0 Step 1.0
                    local7\Field11\Field3[(Int ((local2 * 10.0) + local1))] = readbyte(local11)
                    local28 = (local28 + (Str local7\Field11\Field3[(Int ((local2 * 10.0) + local1))]))
                Next
            Next
            local29 = readfloat(local11)
            local30 = readfloat(local11)
            local31 = readfloat(local11)
            If (local27 = $01) Then
                placeforest(local7\Field11, local29, local30, local31, local7)
            Else
                placeforest_mapcreator(local7\Field11, local29, local30, local31, local7)
            EndIf
        ElseIf (local7\Field11 <> Null) Then
            destroyforest(local7\Field11)
            Delete local7\Field11
        EndIf
    Next
    For local7 = Each rooms
        If (((local13 = local7\Field3) And (local14 = local7\Field5)) <> 0) Then
            i_1499\Field4 = local7
            Exit
        EndIf
    Next
    If (readint(local11) <> $3BA) Then
        runtimeerror("Couldn't load the game, save file may be corrupted (error 2)")
    EndIf
    local32 = 8.0
    local2 = (Float mapheight)
    While (0.0 <= local2)
        If (local2 < (Float (i_zone\Field0[$01] - (selectedmap = "")))) Then
            local33 = $03
        ElseIf (((local2 >= (Float (i_zone\Field0[$01] - (selectedmap = "")))) And (local2 < (Float (i_zone\Field0[$00] - (selectedmap = ""))))) <> 0) Then
            local33 = $02
        Else
            local33 = $01
        EndIf
        local1 = (Float mapwidth)
        While (0.0 <= local1)
            If (maptemp((Int local1), (Int local2)) > $00) Then
                If (local33 = $02) Then
                    local5 = $02
                Else
                    local5 = $00
                EndIf
                For local7 = Each rooms
                    local7\Field6 = (Int wrapangle((Float local7\Field6)))
                    If (((local1 = (Float (Int (local7\Field3 / 8.0)))) And (local2 = (Float (Int (local7\Field5 / 8.0))))) <> 0) Then
                        local34 = $00
                        Select local7\Field7\Field9
                            Case $01
                                If (local7\Field6 = $5A) Then
                                    local34 = $01
                                EndIf
                            Case $02
                                If (((local7\Field6 = $5A) Or (local7\Field6 = $10E)) <> 0) Then
                                    local34 = $01
                                EndIf
                            Case $03
                                If (((local7\Field6 = $00) Or (local7\Field6 = $5A)) <> 0) Then
                                    local34 = $01
                                EndIf
                            Case $04
                                If ((((local7\Field6 = $00) Or (local7\Field6 = $B4)) Or (local7\Field6 = $5A)) <> 0) Then
                                    local34 = $01
                                EndIf
                            Default
                                local34 = $01
                        End Select
                        If (local34 <> 0) Then
                            If ((Float (mapwidth + $01)) > (local1 + 1.0)) Then
                                If (maptemp((Int (local1 + 1.0)), (Int local2)) > $00) Then
                                    local10 = createdoor(local7\Field0, ((local1 * local32) + (local32 / 2.0)), 0.0, (local2 * local32), 90.0, local7, (Int max((Float rand($FFFFFFFD, $01)), 0.0)), local5, $00, "", $00)
                                    local7\Field25[$00] = local10
                                EndIf
                            EndIf
                        EndIf
                        local34 = $00
                        Select local7\Field7\Field9
                            Case $01
                                If (local7\Field6 = $B4) Then
                                    local34 = $01
                                EndIf
                            Case $02
                                If (((local7\Field6 = $00) Or (local7\Field6 = $B4)) <> 0) Then
                                    local34 = $01
                                EndIf
                            Case $03
                                If (((local7\Field6 = $B4) Or (local7\Field6 = $5A)) <> 0) Then
                                    local34 = $01
                                EndIf
                            Case $04
                                If ((((local7\Field6 = $B4) Or (local7\Field6 = $5A)) Or (local7\Field6 = $10E)) <> 0) Then
                                    local34 = $01
                                EndIf
                            Default
                                local34 = $01
                        End Select
                        If (local34 <> 0) Then
                            If ((Float (mapheight + $01)) > (local2 + 1.0)) Then
                                If (maptemp((Int local1), (Int (local2 + 1.0))) > $00) Then
                                    local10 = createdoor(local7\Field0, (local1 * local32), 0.0, ((local2 * local32) + (local32 / 2.0)), 0.0, local7, (Int max((Float rand($FFFFFFFD, $01)), 0.0)), local5, $00, "", $00)
                                    local7\Field25[$03] = local10
                                EndIf
                            EndIf
                        EndIf
                        Exit
                    EndIf
                Next
            EndIf
            local1 = (local1 + -1.0)
        Wend
        local2 = (local2 + -1.0)
    Wend
    local5 = readint(local11)
    For local4 = $01 To local5 Step $01
        local1 = readfloat(local11)
        local2 = readfloat(local11)
        local3 = readfloat(local11)
        local37 = readbyte(local11)
        local38 = readfloat(local11)
        local39 = readbyte(local11)
        local40 = readbyte(local11)
        local41 = readfloat(local11)
        local42 = readfloat(local11)
        local43 = readfloat(local11)
        local44 = readfloat(local11)
        local45 = (Int readfloat(local11))
        local46 = readfloat(local11)
        local47 = readbyte(local11)
        local48 = readbyte(local11)
        For local10 = Each doors
            If ((((local1 = entityx(local10\Field2, $01)) And (local2 = entityy(local10\Field2, $01))) And (local3 = entityz(local10\Field2, $01))) <> 0) Then
                local10\Field5 = local37
                local10\Field7 = local38
                local10\Field4 = local39
                local10\Field21 = local40
                local10\Field10 = local45
                local10\Field11 = local46
                local10\Field23 = local47
                local10\Field24 = local48
                positionentity(local10\Field0, local41, local2, local42, $01)
                If (local10\Field1 <> $00) Then
                    positionentity(local10\Field1, local43, local2, local44, $01)
                EndIf
                Exit
            EndIf
        Next
    Next
    initwaypoints($2D)
    If (readint(local11) <> $735) Then
        runtimeerror("Couldn't load the game, save file corrupted (error 3)")
    EndIf
    For local49 = Each decals
        freeentity(local49\Field0)
        Delete local49
    Next
    local5 = readint(local11)
    For local4 = $01 To local5 Step $01
        local8 = readint(local11)
        local1 = readfloat(local11)
        local2 = readfloat(local11)
        local3 = readfloat(local11)
        local50 = readfloat(local11)
        local51 = readfloat(local11)
        local52 = readfloat(local11)
        local49 = createdecal(local8, local1, local2, local3, local50, local51, local52)
        local49\Field6 = readbyte(local11)
        local49\Field7 = readint(local11)
        local49\Field2 = readfloat(local11)
        local49\Field5 = readfloat(local11)
        local49\Field4 = readfloat(local11)
        local49\Field9 = readfloat(local11)
        local49\Field10 = readfloat(local11)
        scalesprite(local49\Field0, local49\Field2, local49\Field2)
        entityblend(local49\Field0, local49\Field6)
        entityfx(local49\Field0, local49\Field7)
    Next
    updatedecals()
    local5 = readint(local11)
    For local4 = $01 To local5 Step $01
        local53 = (New events)
        local53\Field0 = readstring(local11)
        local53\Field2 = readfloat(local11)
        local53\Field3 = readfloat(local11)
        local53\Field4 = readfloat(local11)
        local53\Field5 = readfloat(local11)
        local1 = readfloat(local11)
        local3 = readfloat(local11)
        For local7 = Each rooms
            If (((local1 = entityx(local7\Field2, $00)) And (local3 = entityz(local7\Field2, $00))) <> 0) Then
                local53\Field1 = local7
                Exit
            EndIf
        Next
        local53\Field15 = readstring(local11)
    Next
    For local53 = Each events
        If (local53\Field0 = "room2sl") Then
            local53\Field2 = 0.0
            local53\Field15 = ""
        ElseIf (local53\Field0 = "dimension1499") Then
            If (0.0 < local53\Field2) Then
                local53\Field2 = 0.0
                local53\Field15 = ""
                hidechunks()
                deletechunks()
                For local9 = Each npcs
                    If (local9\Field5 = $0F) Then
                        If (local9\Field58 = $00) Then
                            removenpc(local9)
                        EndIf
                    EndIf
                Next
                For local54 = Each dummy1499
                    Delete local54
                Next
                debuglog(("Reset Eventstate in " + local53\Field0))
            EndIf
        ElseIf (local53\Field0 = "room860") Then
            local53\Field15 = ""
        ElseIf (local53\Field0 = "room205") Then
            local53\Field15 = ""
        ElseIf (local53\Field0 = "room106") Then
            If (0.0 = local53\Field3) Then
                positionentity(local53\Field1\Field19[$06], entityx(local53\Field1\Field19[$06], $01), (-4512.0 * roomscale), entityz(local53\Field1\Field19[$06], $01), $01)
            EndIf
        EndIf
    Next
    For local55 = Each items
        removeitem(local55)
    Next
    local5 = readint(local11)
    For local4 = $01 To local5 Step $01
        local56 = readstring(local11)
        local57 = readstring(local11)
        local58 = readstring(local11)
        If (local57 = "50ct") Then
            local56 = "Quarter"
            local57 = "25ct"
        EndIf
        local1 = readfloat(local11)
        local2 = readfloat(local11)
        local3 = readfloat(local11)
        local59 = readbyte(local11)
        local60 = readbyte(local11)
        local61 = readbyte(local11)
        local62 = (Int readfloat(local11))
        local55 = createitem(local56, local57, local1, local2, local3, local59, local60, local61, (Float local62), $00)
        local55\Field0 = local58
        entitytype(local55\Field1, $03, $00)
        local1 = readfloat(local11)
        local2 = readfloat(local11)
        rotateentity(local55\Field1, local1, local2, 0.0, $00)
        local55\Field13 = readfloat(local11)
        local55\Field15 = readbyte(local11)
        If (local55\Field15 <> 0) Then
            hideentity(local55\Field1)
        EndIf
        local63 = readbyte(local11)
        If (local63 = $01) Then
            selecteditem = local55
        EndIf
        local63 = readbyte(local11)
        If (local63 < $42) Then
            inventory(local63) = local55
            itemamount = (itemamount + $01)
        EndIf
        For local64 = Each itemtemplates
            If (((local64\Field1 = local57) And (local64\Field0 = local56)) <> 0) Then
                If (local64\Field12 <> $00) Then
                    setanimtime(local55\Field2, readfloat(local11), $00)
                    Exit
                EndIf
            EndIf
        Next
        local55\Field23 = readbyte(local11)
        local55\Field22 = readint(local11)
        If (local55\Field22 > lastitemid) Then
            lastitemid = local55\Field22
        EndIf
        If (readbyte(local11) = $00) Then
            local55\Field17 = local55\Field3\Field7
        Else
            local55\Field17 = local55\Field3\Field8
        EndIf
    Next
    local5 = readint(local11)
    For local4 = $01 To local5 Step $01
        local65 = readint(local11)
        For local66 = Each items
            If (local66\Field22 = local65) Then
                local55 = local66
                Exit
            EndIf
        Next
        For local67 = $00 To (local55\Field23 - $01) Step $01
            local65 = readint(local11)
            If (local65 <> $FFFFFFFF) Then
                For local66 = Each items
                    If (local66\Field22 = local65) Then
                        local55\Field21[local67] = local66
                        Exit
                    EndIf
                Next
            EndIf
        Next
    Next
    For local64 = Each itemtemplates
        local64\Field3 = readbyte(local11)
    Next
    For local10 = Each doors
        If (local10\Field13 <> Null) Then
            local68 = 20.0
            For local7 = Each rooms
                local70 = entitydistance(local7\Field2, local10\Field0)
                If (local68 > local70) Then
                    local68 = local70
                    local69 = local7
                EndIf
            Next
            local10\Field13 = local69
        EndIf
    Next
    If (readint(local11) <> $3E2) Then
        usedconsole = $01
    EndIf
    camerafogfar = readfloat(local11)
    storedcamerafogfar = readfloat(local11)
    If (0.0 = camerafogfar) Then
        camerafogfar = 6.0
    EndIf
    i_427\Field0 = readbyte(local11)
    i_427\Field1 = readfloat(local11)
    If (local0 = "5.5.4") Then
        i_zone\Field0[$00] = readbyte(local11)
        i_zone\Field0[$01] = readbyte(local11)
        i_zone\Field1 = readbyte(local11)
        i_zone\Field2 = readbyte(local11)
    EndIf
    i_714\Field0 = readbyte(local11)
    maxitemamount = readbyte(local11)
    closefile(local11)
    For local7 = Each rooms
        local7\Field24[$00] = Null
        local7\Field24[$01] = Null
        local7\Field24[$02] = Null
        local7\Field24[$03] = Null
        For local71 = Each rooms
            If (local7 <> local71) Then
                If (local7\Field5 = local71\Field5) Then
                    If ((local7\Field3 + 8.0) = local71\Field3) Then
                        local7\Field24[$00] = local71
                        If (local7\Field25[$00] = Null) Then
                            local7\Field25[$00] = local71\Field25[$02]
                        EndIf
                    ElseIf ((local7\Field3 - 8.0) = local71\Field3) Then
                        local7\Field24[$02] = local71
                        If (local7\Field25[$02] = Null) Then
                            local7\Field25[$02] = local71\Field25[$00]
                        EndIf
                    EndIf
                ElseIf (local7\Field3 = local71\Field3) Then
                    If ((local7\Field5 - 8.0) = local71\Field5) Then
                        local7\Field24[$01] = local71
                        If (local7\Field25[$01] = Null) Then
                            local7\Field25[$01] = local71\Field25[$03]
                        EndIf
                    ElseIf ((local7\Field5 + 8.0) = local71\Field5) Then
                        local7\Field24[$03] = local71
                        If (local7\Field25[$03] = Null) Then
                            local7\Field25[$03] = local71\Field25[$01]
                        EndIf
                    EndIf
                EndIf
            EndIf
            If (((((local7\Field24[$00] <> Null) And (local7\Field24[$01] <> Null)) And (local7\Field24[$02] <> Null)) And (local7\Field24[$03] <> Null)) <> 0) Then
                Exit
            EndIf
        Next
        For local10 = Each doors
            If (((local10\Field12 = $00) And (local10\Field17 = "")) <> 0) Then
                If (local7\Field5 = entityz(local10\Field2, $01)) Then
                    If ((local7\Field3 + 4.0) = entityx(local10\Field2, $01)) Then
                        local7\Field25[$00] = local10
                    ElseIf ((local7\Field3 - 4.0) = entityx(local10\Field2, $01)) Then
                        local7\Field25[$02] = local10
                    EndIf
                ElseIf (local7\Field3 = entityx(local10\Field2, $01)) Then
                    If ((local7\Field5 + 4.0) = entityz(local10\Field2, $01)) Then
                        local7\Field25[$03] = local10
                    ElseIf ((local7\Field5 - 4.0) = entityz(local10\Field2, $01)) Then
                        local7\Field25[$01] = local10
                    EndIf
                EndIf
            EndIf
        Next
    Next
    If (playerroom\Field7\Field10 = "dimension1499") Then
        blinktimer = -1.0
        shouldentitiesfall = $00
        playerroom = i_1499\Field4
        updatedoors()
        updaterooms()
        For local55 = Each items
            local55\Field12 = 0.0
        Next
    EndIf
    If (collider <> $00) Then
        If (playerroom <> Null) Then
            showentity(playerroom\Field2)
        EndIf
        showentity(collider)
        teleportentity(collider, entityx(collider, $00), (entityy(collider, $00) + 0.5), entityz(collider, $00), 0.3, $01, 2.0, $00)
        If (playerroom <> Null) Then
            hideentity(playerroom\Field2)
        EndIf
    EndIf
    updatedoorstimer = 0.0
    Return $00
End Function
