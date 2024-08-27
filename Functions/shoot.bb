Function shoot%(arg0#, arg1#, arg2#, arg3#, arg4%, arg5%)
    Local local0.particles
    Local local1$
    Local local3.npcs
    Local local7%
    Local local8%
    Local local9.decals
    local0 = createparticle(arg0, arg1, arg2, $01, rnd(0.08, 0.1), 0.0, $05)
    turnentity(local0\Field0, 0.0, 0.0, rnd(360.0, 0.0), $00)
    local0\Field14 = -0.15
    lightvolume = (templightvolume * 1.2)
    If (arg5 <> 0) Then
        kill($01, $00)
        playsound_strict(bullethitsfx)
        Return $00
    EndIf
    If (arg3 >= rnd(1.0, 0.0)) Then
        turnentity(camera, rnd(-3.0, 3.0), rnd(-3.0, 3.0), 0.0, $00)
        If (((wearingvest > $00) And (wearinghelmet = $00)) <> 0) Then
            If (wearingvest = $01) Then
                Select rand($10, $01)
                    Case $01,$02,$03,$04,$05,$06,$07,$08,$09
                        blurtimer = 650.0
                        stamina = 0.0
                        If (i_1033ru\Field0 = $00) Then
                            local1 = scplang_getphrase("events.shot1")
                            injuries = (rnd(0.1, 0.2) + injuries)
                        Else
                            local1 = scplang_getphrase("events.shot2")
                            damage1033ru(((rand($05, $01) * selecteddifficulty\Field3) + $05))
                        EndIf
                    Case $0A
                        blurtimer = 650.0
                        stamina = 0.0
                        If (i_1033ru\Field0 = $00) Then
                            local1 = scplang_getphrase("events.shot3")
                            injuries = (rnd(0.7, 0.9) + injuries)
                        Else
                            local1 = scplang_getphrase("events.shot4")
                            damage1033ru(((rand($05, $01) * selecteddifficulty\Field3) + $0F))
                        EndIf
                    Case $0B
                        blurtimer = 650.0
                        stamina = 0.0
                        If (i_1033ru\Field0 = $00) Then
                            local1 = scplang_getphrase("events.shot5")
                            injuries = (rnd(0.7, 0.9) + injuries)
                        Else
                            local1 = scplang_getphrase("events.shot6")
                            damage1033ru(((rand($05, $01) * selecteddifficulty\Field3) + $0F))
                        EndIf
                    Case $0C
                        blurtimer = 650.0
                        If (i_1033ru\Field0 = $00) Then
                            local1 = scplang_getphrase("events.shot7")
                            injuries = (rnd(0.5, 0.7) + injuries)
                        Else
                            local1 = scplang_getphrase("events.shot8")
                            damage1033ru(((rand($05, $01) * selecteddifficulty\Field3) + $0A))
                        EndIf
                    Case $0D
                        blurtimer = 650.0
                        If (i_1033ru\Field0 = $00) Then
                            local1 = scplang_getphrase("events.shot9")
                            injuries = (rnd(0.5, 0.7) + injuries)
                        Else
                            local1 = scplang_getphrase("events.shot10")
                            damage1033ru(((rand($05, $01) * selecteddifficulty\Field3) + $0A))
                        EndIf
                    Case $0E
                        blurtimer = 650.0
                        stamina = 0.0
                        If (i_1033ru\Field0 = $00) Then
                            local1 = scplang_getphrase("events.shot11")
                            injuries = (rnd(1.1, 1.3) + injuries)
                        Else
                            damage1033ru(((rand($05, $01) * selecteddifficulty\Field3) + $23))
                            local1 = scplang_getphrase("events.shot12")
                        EndIf
                    Case $0F
                        local1 = scplang_getphrase("events.shot13")
                        kill($01, $00)
                    Case $10
                        For local3 = Each npcs
                            If (((local3\Field5 = $14) Or (local3\Field5 = $1C)) <> 0) Then
                                If ((entityinview(local3\Field0, camera) And entityvisible(local3\Field0, camera)) <> 0) Then
                                    local1 = scplang_getphrase("events.shot14")
                                    kill($01, $00)
                                Else
                                    local1 = scplang_getphrase("events.shot13")
                                    kill($01, $00)
                                EndIf
                            EndIf
                        Next
                End Select
            ElseIf (rand($0A, $01) = $01) Then
                blurtimer = 650.0
                stamina = (stamina - 1.0)
                If (i_1033ru\Field0 = $00) Then
                    local1 = scplang_getphrase("events.shot15")
                    injuries = (rnd(0.7, 0.8) + injuries)
                Else
                    local1 = scplang_getphrase("events.shot16")
                    damage1033ru(((rand($05, $01) * selecteddifficulty\Field3) + $1E))
                EndIf
            Else
                blurtimer = 650.0
                If (i_1033ru\Field0 = $00) Then
                    local1 = scplang_getphrase("events.shot17")
                    injuries = (rnd(0.1, 0.2) + injuries)
                Else
                    local1 = scplang_getphrase("events.shot16")
                    damage1033ru(((rand($05, $01) * selecteddifficulty\Field3) + $05))
                EndIf
            EndIf
        ElseIf (((wearingvest > $00) And (wearinghelmet > $00)) <> 0) Then
            If (wearingvest = $01) Then
                Select rand($16, $01)
                    Case $01,$02,$03,$04,$05,$06,$07,$08,$09
                        blurtimer = 650.0
                        stamina = 0.0
                        If (i_1033ru\Field0 = $00) Then
                            local1 = scplang_getphrase("events.shot1")
                            injuries = (rnd(0.1, 0.2) + injuries)
                        Else
                            local1 = scplang_getphrase("events.shot2")
                            damage1033ru(((rand($05, $01) * selecteddifficulty\Field3) + $05))
                        EndIf
                    Case $0A
                        blurtimer = 650.0
                        stamina = 0.0
                        If (i_1033ru\Field0 = $00) Then
                            local1 = scplang_getphrase("events.shot3")
                            injuries = (rnd(0.7, 0.9) + injuries)
                        Else
                            local1 = scplang_getphrase("events.shot4")
                            damage1033ru(((rand($05, $01) * selecteddifficulty\Field3) + $0F))
                        EndIf
                    Case $0B
                        blurtimer = 650.0
                        stamina = 0.0
                        If (i_1033ru\Field0 = $00) Then
                            local1 = scplang_getphrase("events.shot5")
                            injuries = (rnd(0.7, 0.9) + injuries)
                        Else
                            local1 = scplang_getphrase("events.shot6")
                            damage1033ru(((rand($05, $01) * selecteddifficulty\Field3) + $0F))
                        EndIf
                    Case $0C
                        blurtimer = 650.0
                        If (i_1033ru\Field0 = $00) Then
                            local1 = scplang_getphrase("events.shot7")
                            injuries = (rnd(0.5, 0.7) + injuries)
                        Else
                            local1 = scplang_getphrase("events.shot8")
                            damage1033ru(((rand($05, $01) * selecteddifficulty\Field3) + $0A))
                        EndIf
                    Case $0D
                        blurtimer = 650.0
                        If (i_1033ru\Field0 = $00) Then
                            local1 = scplang_getphrase("events.shot9")
                            injuries = (rnd(0.5, 0.7) + injuries)
                        Else
                            local1 = scplang_getphrase("events.shot10")
                            damage1033ru(((rand($05, $01) * selecteddifficulty\Field3) + $0A))
                        EndIf
                    Case $0E
                        blurtimer = 650.0
                        stamina = 0.0
                        If (i_1033ru\Field0 = $00) Then
                            local1 = scplang_getphrase("events.shot11")
                            injuries = (rnd(1.1, 1.3) + injuries)
                        Else
                            damage1033ru(((rand($05, $01) * selecteddifficulty\Field3) + $23))
                            local1 = scplang_getphrase("events.shot12")
                        EndIf
                    Case $0F,$10,$11,$12,$13,$14,$15
                        blurtimer = 650.0
                        local1 = scplang_getphrase("events.shot18")
                    Case $16
                        For local3 = Each npcs
                            If (((local3\Field5 = $14) Or (local3\Field5 = $1C)) <> 0) Then
                                If ((entityinview(local3\Field0, camera) And entityvisible(local3\Field0, camera)) <> 0) Then
                                    local1 = scplang_getphrase("events.shot14")
                                    kill($01, $00)
                                ElseIf (wearinghelmet > $00) Then
                                    blurtimer = 500.0
                                    local1 = scplang_getphrase("events.shot18")
                                Else
                                    local1 = scplang_getphrase("events.shot13")
                                    kill($01, $00)
                                EndIf
                            EndIf
                        Next
                End Select
            ElseIf (rand($0A, $01) = $01) Then
                blurtimer = 650.0
                stamina = (stamina - 1.0)
                If (i_1033ru\Field0 = $00) Then
                    local1 = scplang_getphrase("events.shot15")
                    injuries = (rnd(0.7, 0.9) + injuries)
                Else
                    local1 = scplang_getphrase("events.shot16")
                    damage1033ru(((rand($05, $01) * selecteddifficulty\Field3) + $1E))
                EndIf
            ElseIf (i_1033ru\Field0 = $00) Then
                local1 = scplang_getphrase("events.shot17")
                injuries = (rnd(0.1, 0.2) + injuries)
            Else
                local1 = scplang_getphrase("events.shot16")
                damage1033ru(((rand($05, $01) * selecteddifficulty\Field3) + $05))
            EndIf
        ElseIf (((wearingvest = $00) And (wearinghelmet > $00)) <> 0) Then
            Select rand($11, $01)
                Case $01,$02,$03,$04,$05,$06,$07
                    blurtimer = 650.0
                    local1 = scplang_getphrase("events.shot18")
                Case $08
                    blurtimer = 650.0
                    stamina = 0.0
                    If (i_1033ru\Field0 = $00) Then
                        local1 = scplang_getphrase("events.shot3")
                        injuries = (rnd(0.7, 0.9) + injuries)
                    Else
                        local1 = scplang_getphrase("events.shot4")
                        damage1033ru(((rand($05, $01) * selecteddifficulty\Field3) + $0F))
                    EndIf
                Case $09
                    blurtimer = 650.0
                    stamina = 0.0
                    If (i_1033ru\Field0 = $00) Then
                        local1 = scplang_getphrase("events.shot5")
                        injuries = (rnd(0.7, 0.9) + injuries)
                    Else
                        local1 = scplang_getphrase("events.shot6")
                        damage1033ru(((rand($05, $01) * selecteddifficulty\Field3) + $0F))
                    EndIf
                Case $0A
                    blurtimer = 650.0
                    If (i_1033ru\Field0 = $00) Then
                        local1 = scplang_getphrase("events.shot7")
                        injuries = (rnd(0.5, 0.7) + injuries)
                    Else
                        local1 = scplang_getphrase("events.shot8")
                        damage1033ru(((rand($05, $01) * selecteddifficulty\Field3) + $0A))
                    EndIf
                Case $0B
                    blurtimer = 650.0
                    If (i_1033ru\Field0 = $00) Then
                        local1 = scplang_getphrase("events.shot9")
                        injuries = (rnd(0.5, 0.7) + injuries)
                    Else
                        local1 = scplang_getphrase("events.shot10")
                        damage1033ru(((rand($05, $01) * selecteddifficulty\Field3) + $0A))
                    EndIf
                Case $0C
                    blurtimer = 650.0
                    If (i_1033ru\Field0 = $00) Then
                        local1 = scplang_getphrase("events.shot19")
                        injuries = (rnd(0.9, 1.1) + injuries)
                    Else
                        local1 = scplang_getphrase("events.shot20")
                        damage1033ru(((rand($05, $01) * selecteddifficulty\Field3) + $19))
                    EndIf
                Case $0D
                    blurtimer = 650.0
                    If (i_1033ru\Field0 = $00) Then
                        local1 = scplang_getphrase("events.shot21")
                        injuries = (rnd(0.9, 1.1) + injuries)
                    Else
                        local1 = scplang_getphrase("events.shot22")
                        damage1033ru(((rand($05, $01) * selecteddifficulty\Field3) + $19))
                    EndIf
                Case $0E
                    blurtimer = 650.0
                    If (i_1033ru\Field0 = $00) Then
                        local1 = scplang_getphrase("events.shot19")
                        injuries = (rnd(2.4, 2.6) + injuries)
                    Else
                        local1 = scplang_getphrase("events.shot20")
                        damage1033ru(((rand($05, $01) * selecteddifficulty\Field3) + $19))
                    EndIf
                Case $0F
                    blurtimer = 650.0
                    If (i_1033ru\Field0 = $00) Then
                        local1 = scplang_getphrase("events.shot21")
                        injuries = (rnd(2.4, 2.6) + injuries)
                    Else
                        local1 = scplang_getphrase("events.shot22")
                        damage1033ru(((rand($05, $01) * selecteddifficulty\Field3) + $19))
                    EndIf
                Case $10
                    blurtimer = 650.0
                    stamina = 0.0
                    If (i_1033ru\Field0 = $00) Then
                        local1 = scplang_getphrase("events.shot11")
                        injuries = (rnd(1.1, 1.3) + injuries)
                    Else
                        damage1033ru(((rand($05, $01) * selecteddifficulty\Field3) + $23))
                        local1 = scplang_getphrase("events.shot12")
                    EndIf
                Case $11
                    For local3 = Each npcs
                        If (((local3\Field5 = $14) Or (local3\Field5 = $1C)) <> 0) Then
                            If ((entityinview(local3\Field0, camera) And entityvisible(local3\Field0, camera)) <> 0) Then
                                local1 = scplang_getphrase("events.shot14")
                                kill($01, $00)
                            ElseIf (wearinghelmet > $00) Then
                                blurtimer = 500.0
                                local1 = scplang_getphrase("events.shot18")
                            Else
                                local1 = scplang_getphrase("events.shot13")
                                kill($01, $00)
                            EndIf
                        EndIf
                    Next
            End Select
        ElseIf (((wearingvest = $00) And (wearinghelmet = $00)) <> 0) Then
            Select rand($0B, $01)
                Case $01
                    local1 = scplang_getphrase("events.shot13")
                    kill($01, $00)
                Case $02
                    blurtimer = 650.0
                    stamina = 0.0
                    If (i_1033ru\Field0 = $00) Then
                        local1 = scplang_getphrase("events.shot3")
                        injuries = (rnd(0.7, 0.9) + injuries)
                    Else
                        local1 = scplang_getphrase("events.shot4")
                        damage1033ru(((rand($05, $01) * selecteddifficulty\Field3) + $0F))
                    EndIf
                Case $03
                    blurtimer = 650.0
                    stamina = 0.0
                    If (i_1033ru\Field0 = $00) Then
                        local1 = scplang_getphrase("events.shot5")
                        injuries = (rnd(0.7, 0.9) + injuries)
                    Else
                        local1 = scplang_getphrase("events.shot6")
                        damage1033ru(((rand($05, $01) * selecteddifficulty\Field3) + $0F))
                    EndIf
                Case $04
                    blurtimer = 650.0
                    If (i_1033ru\Field0 = $00) Then
                        local1 = scplang_getphrase("events.shot19")
                        injuries = (rnd(0.9, 1.1) + injuries)
                    Else
                        local1 = scplang_getphrase("events.shot20")
                        damage1033ru(((rand($05, $01) * selecteddifficulty\Field3) + $19))
                    EndIf
                Case $05
                    blurtimer = 650.0
                    If (i_1033ru\Field0 = $00) Then
                        local1 = scplang_getphrase("events.shot21")
                        injuries = (rnd(0.9, 1.1) + injuries)
                    Else
                        local1 = scplang_getphrase("events.shot22")
                        damage1033ru(((rand($05, $01) * selecteddifficulty\Field3) + $19))
                    EndIf
                Case $06
                    blurtimer = 650.0
                    If (i_1033ru\Field0 = $00) Then
                        local1 = scplang_getphrase("events.shot19")
                        injuries = (rnd(2.4, 2.6) + injuries)
                    Else
                        local1 = scplang_getphrase("events.shot20")
                        damage1033ru(((rand($05, $01) * selecteddifficulty\Field3) + $19))
                    EndIf
                Case $07
                    blurtimer = 650.0
                    If (i_1033ru\Field0 = $00) Then
                        local1 = scplang_getphrase("events.shot21")
                        injuries = (rnd(2.4, 2.6) + injuries)
                    Else
                        local1 = scplang_getphrase("events.shot22")
                        damage1033ru(((rand($05, $01) * selecteddifficulty\Field3) + $19))
                    EndIf
                Case $08
                    blurtimer = 650.0
                    If (i_1033ru\Field0 = $00) Then
                        local1 = scplang_getphrase("events.shot7")
                        injuries = (rnd(0.5, 0.7) + injuries)
                    Else
                        local1 = scplang_getphrase("events.shot8")
                        damage1033ru(((rand($05, $01) * selecteddifficulty\Field3) + $0A))
                    EndIf
                Case $09
                    blurtimer = 650.0
                    If (i_1033ru\Field0 = $00) Then
                        local1 = scplang_getphrase("events.shot9")
                        injuries = (rnd(0.5, 0.7) + injuries)
                    Else
                        local1 = scplang_getphrase("events.shot10")
                        damage1033ru(((rand($05, $01) * selecteddifficulty\Field3) + $0A))
                    EndIf
                Case $0A
                    blurtimer = 650.0
                    stamina = 0.0
                    If (i_1033ru\Field0 = $00) Then
                        local1 = scplang_getphrase("events.shot11")
                        injuries = (rnd(1.1, 1.3) + injuries)
                    Else
                        damage1033ru(((rand($05, $01) * selecteddifficulty\Field3) + $23))
                        local1 = scplang_getphrase("events.shot12")
                    EndIf
                Case $0B
                    For local3 = Each npcs
                        If (((local3\Field5 = $14) Or (local3\Field5 = $1C)) <> 0) Then
                            If ((entityinview(local3\Field0, camera) And entityvisible(local3\Field0, camera)) <> 0) Then
                                local1 = scplang_getphrase("events.shot14")
                                kill($01, $00)
                            Else
                                local1 = scplang_getphrase("events.shot13")
                                kill($01, $00)
                            EndIf
                        EndIf
                    Next
            End Select
        EndIf
        If (280.0 > msgtimer) Then
            msg = local1
            msgtimer = 420.0
        EndIf
        playsound_strict(bullethitsfx)
    ElseIf ((arg4 And (particleamount > $00)) <> 0) Then
        local7 = createpivot($00)
        positionentity(local7, entityx(collider, $00), ((entityy(collider, $00) + entityy(camera, $00)) / 2.0), entityz(collider, $00), $00)
        pointentity(local7, local0\Field0, 0.0)
        turnentity(local7, 0.0, 180.0, 0.0, $00)
        entitypick(local7, 2.5)
        If (pickedentity() <> $00) Then
            playsound2(gunshot3sfx, camera, local7, 0.4, rnd(0.8, 1.0))
            If (arg4 <> 0) Then
                local0 = createparticle(pickedx(), pickedy(), pickedz(), $00, 0.03, 0.0, $50)
                local0\Field8 = 0.001
                local0\Field15 = 0.003
                local0\Field6 = 0.8
                local0\Field14 = -0.01
                rotateentity(local0\Field1, (entitypitch(local7, $00) - 180.0), entityyaw(local7, $00), 0.0, $00)
                For local8 = $00 To rand($02, $03) Step $01
                    local0 = createparticle(pickedx(), pickedy(), pickedz(), $00, 0.006, 0.003, $50)
                    local0\Field8 = 0.02
                    local0\Field6 = 0.8
                    local0\Field14 = -0.01
                    rotateentity(local0\Field1, (entitypitch(local7, $00) + rnd(170.0, 190.0)), (entityyaw(local7, $00) + rnd(-10.0, 10.0)), 0.0, $00)
                Next
                local9 = createdecal(rand($0D, $0E), pickedx(), (rnd(-0.05, 0.05) + pickedy()), pickedz(), rnd(-4.0, 4.0), rnd(-4.0, 4.0), rnd(-4.0, 4.0))
                aligntovector(local9\Field0, (- pickednx()), (- pickedny()), (- pickednz()), $03, 1.0)
                moveentity(local9\Field0, 0.0, 0.0, -0.001)
                entityfx(local9\Field0, $01)
                local9\Field10 = 1400.0
                entityblend(local9\Field0, $02)
                local9\Field2 = rnd(0.028, 0.034)
                scalesprite(local9\Field0, local9\Field2, local9\Field2)
            EndIf
        EndIf
        freeentity(local7)
    EndIf
    Return $00
End Function
