Function initnewgame%()
    Local local0%
    Local local1.decals
    Local local2.doors
    Local local3.items
    Local local4.rooms
    Local local5.securitycams
    Local local6.events
    Local local7.fonts
    Local local8.fps_settings
    Local local9.roomtemplates
    Local local10.tempwaypoints
    local7 = (First fonts)
    local8 = (First fps_settings)
    drawloading($2D, $00)
    hidedistance = 15.0
    heartbeatrate = 70.0
    accesscode = $00
    For local0 = $00 To $03 Step $01
        accesscode = (Int (((Float rand($01, $09)) * (10.0 ^ (Float local0))) + (Float accesscode)))
    Next
    If (selectedmap = "") Then
        createmap()
    Else
        loadmap(scpmodding_processfilepath(("Map Creator\Maps\" + selectedmap)))
    EndIf
    initwaypoints($2D)
    drawloading($4F, $00)
    curr173 = createnpc($08, 0.0, -30.0, 0.0)
    curr106 = createnpc($07, 0.0, -30.0, 0.0)
    curr106\Field9 = (Float (rand($0C, $11) * $1068))
    For local2 = Each doors
        entityparent(local2\Field0, $00, $01)
        If (local2\Field1 <> $00) Then
            entityparent(local2\Field1, $00, $01)
        EndIf
        If (local2\Field2 <> $00) Then
            entityparent(local2\Field2, $00, $01)
        EndIf
        If (local2\Field3[$00] <> $00) Then
            entityparent(local2\Field3[$00], $00, $01)
        EndIf
        If (local2\Field3[$01] <> $00) Then
            entityparent(local2\Field3[$01], $00, $01)
        EndIf
        If (((local2\Field1 <> $00) And (local2\Field9 = $00)) <> 0) Then
            moveentity(local2\Field0, 0.0, 0.0, (8.0 * roomscale))
            moveentity(local2\Field1, 0.0, 0.0, (8.0 * roomscale))
        EndIf
    Next
    For local3 = Each items
        entitytype(local3\Field1, $03, $00)
        entityparent(local3\Field1, $00, $01)
    Next
    drawloading($50, $00)
    For local5 = Each securitycams
        local5\Field11 = (entityyaw(local5\Field0, $00) + local5\Field11)
        entityparent(local5\Field0, $00, $01)
    Next
    For local4 = Each rooms
        For local0 = $00 To $20 Step $01
            If (local4\Field16[local0] <> $00) Then
                entityparent(local4\Field16[local0], $00, $01)
            EndIf
        Next
        If (local4\Field7\Field13 = $00) Then
            If (rand($04, $01) = $01) Then
                local1 = createdecal(rand($02, $03), (entityx(local4\Field2, $00) + rnd(-2.0, 2.0)), 0.003, (entityz(local4\Field2, $00) + rnd(-2.0, 2.0)), 90.0, (Float rand($168, $01)), 0.0)
                local1\Field2 = rnd(0.1, 0.4)
                scalesprite(local1\Field0, local1\Field2, local1\Field2)
                entityalpha(local1\Field0, rnd(0.85, 0.95))
            EndIf
            If (rand($04, $01) = $01) Then
                local1 = createdecal($00, (entityx(local4\Field2, $00) + rnd(-2.0, 2.0)), 0.003, (entityz(local4\Field2, $00) + rnd(-2.0, 2.0)), 90.0, (Float rand($168, $01)), 0.0)
                local1\Field2 = rnd(0.5, 0.7)
                entityalpha(local1\Field0, 0.7)
                local1\Field8 = $01
                scalesprite(local1\Field0, local1\Field2, local1\Field2)
                entityalpha(local1\Field0, rnd(0.7, 0.85))
            EndIf
        EndIf
        If (((local4\Field7\Field10 = "room173") And (introenabled = $00)) <> 0) Then
            positionentity(collider, (entityx(local4\Field2, $00) + (3584.0 * roomscale)), (704.0 * roomscale), (entityz(local4\Field2, $00) + (1024.0 * roomscale)), $00)
            playerroom = local4
            local3 = createitem("Class D Orientation Leaflet", "paper", 1.0, 1.0, 1.0, $00, $00, $00, 1.0, $00)
            local3\Field15 = $01
            local3\Field16 = $FFFFFFFF
            local3\Field3\Field3 = $01
            inventory($00) = local3
            hideentity(local3\Field1)
            entitytype(local3\Field1, $03, $00)
            entityparent(local3\Field1, $00, $01)
            itemamount = (itemamount + $01)
            local3 = createitem("Document SCP-173", "paper", 1.0, 1.0, 1.0, $00, $00, $00, 1.0, $00)
            local3\Field15 = $01
            local3\Field16 = $FFFFFFFF
            local3\Field3\Field3 = $01
            inventory($01) = local3
            hideentity(local3\Field1)
            entitytype(local3\Field1, $03, $00)
            entityparent(local3\Field1, $00, $01)
            itemamount = (itemamount + $01)
            If (selecteddifficulty\Field11 = $00) Then
                maxitemamount = $0A
            Else
                maxitemamount = $02
            EndIf
        ElseIf (((local4\Field7\Field10 = "room173intro") And introenabled) <> 0) Then
            positionentity(collider, entityx(local4\Field2, $00), 1.0, entityz(local4\Field2, $00), $00)
            playerroom = local4
            If (selecteddifficulty\Field11 = $00) Then
                maxitemamount = $0A
            Else
                maxitemamount = $02
            EndIf
        EndIf
        If ((((selecteddifficulty\Field10 = $00) And (local4\Field7\Field10 = "room173")) And (introenabled = $00)) <> 0) Then
            positionentity(collider, (entityx(local4\Field2, $00) + (3584.0 * roomscale)), (704.0 * roomscale), (entityz(local4\Field2, $00) + (1024.0 * roomscale)), $00)
            playerroom = local4
            itemamount = (itemamount + $01)
            If (selecteddifficulty\Field11 = $00) Then
                maxitemamount = $0A
            Else
                maxitemamount = $02
            EndIf
        ElseIf ((((selecteddifficulty\Field10 = $00) And (local4\Field7\Field10 = "room173intro")) And introenabled) <> 0) Then
            positionentity(collider, entityx(local4\Field2, $00), 1.0, entityz(local4\Field2, $00), $00)
            itemamount = (itemamount + $01)
            playerroom = local4
            If (selecteddifficulty\Field11 = $00) Then
                maxitemamount = $0A
            Else
                maxitemamount = $02
            EndIf
        EndIf
    Next
    For local9 = Each roomtemplates
        freeentity(local9\Field0)
    Next
    For local10 = Each tempwaypoints
        Delete local10
    Next
    turnentity(collider, 0.0, (Float rand($A0, $C8)), 0.0, $00)
    resetentity(collider)
    If (selectedmap = "") Then
        initevents()
    EndIf
    For local6 = Each events
        If (local6\Field0 = "room2nuke") Then
            local6\Field2 = 1.0
        EndIf
        If (local6\Field0 = "room106") Then
            local6\Field3 = 1.0
        EndIf
        If (local6\Field0 = "room2sl") Then
            local6\Field4 = 1.0
        EndIf
    Next
    movemouse(viewport_center_x, viewport_center_y)
    aasetfont(local7\Field0[$00])
    hidepointer()
    If (unlockthaumiel = $01) Then
        achievements($3A) = $01
        scpsteam_setachievement("s58")
    EndIf
    blinktimer = -10.0
    blurtimer = 100.0
    stamina = 100.0
    For local0 = $00 To $46 Step $01
        local8\Field3[$00] = 1.0
        flushkeys()
        moveplayer()
        updatedoors()
        updatenpcs()
        updateworld(1.0)
        If ((Int ((Float local0) * 0.27)) <> (Int ((Float (local0 - $01)) * 0.27))) Then
            drawloading(((Int ((Float local0) * 0.27)) + $50), $00)
        EndIf
    Next
    freetexturecache()
    drawloading($64, $00)
    flushkeys()
    flushmouse()
    dropspeed = 0.0
    local8\Field1 = millisecs()
    Return $00
End Function
