Function updateleave1499%()
    Local local0.rooms
    Local local1.items
    Local local2.rooms
    Local local3%
    Local local4.rooms
    Local local5.events
    If (((i_1499\Field0 = $00) And (playerroom\Field7\Field10 = "dimension1499")) <> 0) Then
        For local0 = Each rooms
            If (local0 = i_1499\Field4) Then
                blinktimer = -1.0
                i_1499\Field5 = entityx(collider, $00)
                i_1499\Field6 = entityy(collider, $00)
                i_1499\Field7 = entityz(collider, $00)
                positionentity(collider, i_1499\Field1, (i_1499\Field2 + 0.05), i_1499\Field3, $00)
                resetentity(collider)
                playerroom = local0
                updatedoors()
                updaterooms()
                If (playerroom\Field7\Field10 = "room3storage") Then
                    If ((-4600.0 * roomscale) > entityy(collider, $00)) Then
                        For local3 = $00 To $03 Step $01
                            playerroom\Field22[local3]\Field9 = 2.0
                            positionentity(playerroom\Field22[local3]\Field4, entityx(playerroom\Field19[(Int playerroom\Field22[local3]\Field10)], $01), (entityy(playerroom\Field19[(Int playerroom\Field22[local3]\Field10)], $01) + 0.2), entityz(playerroom\Field19[(Int playerroom\Field22[local3]\Field10)], $01), $00)
                            resetentity(playerroom\Field22[local3]\Field4)
                            playerroom\Field22[local3]\Field10 = (playerroom\Field22[local3]\Field10 + 1.0)
                            If ((Float playerroom\Field22[local3]\Field12) < playerroom\Field22[local3]\Field10) Then
                                playerroom\Field22[local3]\Field10 = (Float (playerroom\Field22[local3]\Field12 - $03))
                            EndIf
                        Next
                    EndIf
                ElseIf (playerroom\Field7\Field10 = "pocketdimension") Then
                    camerafogcolor(camera, 0.0, 0.0, 0.0)
                    cameraclscolor(camera, 0.0, 0.0, 0.0)
                ElseIf (playerroom\Field7\Field10 = "room457") Then
                    If ((-2400.0 * roomscale) > entityy(collider, $00)) Then
                        If (contained457 = $00) Then
                            For local5 = Each events
                                If (local5\Field0 = "room457") Then
                                    positionentity(playerroom\Field22[$00]\Field4, entityx(playerroom\Field19[(Int (local5\Field2 - 1.0))], $01), (entityy(playerroom\Field19[(Int (local5\Field2 - 1.0))], $01) + 0.1), entityz(playerroom\Field19[(Int (local5\Field2 - 1.0))], $01), $00)
                                    If (playerroom\Field22[$00]\Field37 = $01) Then
                                        playerroom\Field22[$00]\Field37 = $00
                                    EndIf
                                EndIf
                            Next
                        Else
                            positionentity(playerroom\Field22[$00]\Field4, entityx(playerroom\Field19[$04], $01), (entityy(playerroom\Field19[$04], $01) + 0.1), entityz(playerroom\Field19[$04], $01), $00)
                        EndIf
                        playerroom\Field22[$00]\Field9 = 0.0
                        resetentity(playerroom\Field22[$00]\Field4)
                    EndIf
                EndIf
                For local2 = Each rooms
                    If (local2\Field7\Field10 = "dimension1499") Then
                        local4 = local2
                        Exit
                    EndIf
                Next
                For local1 = Each items
                    local1\Field12 = 0.0
                    If (((local1\Field3\Field1 = "scp1499") Or (local1\Field3\Field1 = "super1499")) <> 0) Then
                        If ((entityy(local4\Field2, $00) - 5.0) <= entityy(local1\Field1, $00)) Then
                            positionentity(local1\Field1, i_1499\Field1, ((entityy(local1\Field1, $00) - entityy(local4\Field2, $00)) + i_1499\Field2), i_1499\Field3, $00)
                            resetentity(local1\Field1)
                            Exit
                        EndIf
                    EndIf
                Next
                local4 = Null
                shouldentitiesfall = $00
                playsound_strict(loadtempsound(scpmodding_processfilepath("SFX\SCP\1499\Exit.ogg")))
                i_1499\Field1 = 0.0
                i_1499\Field2 = 0.0
                i_1499\Field3 = 0.0
                i_1499\Field4 = Null
                Exit
            EndIf
        Next
    EndIf
    Return $00
End Function
