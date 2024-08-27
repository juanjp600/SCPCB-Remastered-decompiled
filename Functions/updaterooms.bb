Function updaterooms%()
    Local local0#
    Local local1%
    Local local2%
    Local local3.rooms
    Local local4#
    Local local5#
    Local local6%
    Local local7%
    local6 = $01
    If ((entityz(collider, $00) / 8.0) < (Float (i_zone\Field0[$01] - (selectedmap = "")))) Then
        playerzone = $02
    ElseIf ((((entityz(collider, $00) / 8.0) >= (Float (i_zone\Field0[$01] - (selectedmap = "")))) And ((entityz(collider, $00) / 8.0) < (Float (i_zone\Field0[$00] - (selectedmap = ""))))) <> 0) Then
        playerzone = $01
    Else
        playerzone = $00
    EndIf
    templightvolume = 0.0
    local7 = $00
    If (playerroom <> Null) Then
        If (1.5 > (Abs (entityy(collider, $00) - entityy(playerroom\Field2, $00)))) Then
            local4 = (Abs (playerroom\Field3 - entityx(collider, $01)))
            If (4.0 > local4) Then
                local5 = (Abs (playerroom\Field5 - entityz(collider, $01)))
                If (4.0 > local5) Then
                    local7 = $01
                EndIf
            EndIf
            If (local7 = $00) Then
                For local1 = $00 To $03 Step $01
                    If (playerroom\Field24[local1] <> Null) Then
                        local4 = (Abs (playerroom\Field24[local1]\Field3 - entityx(collider, $01)))
                        If (4.0 > local4) Then
                            local5 = (Abs (playerroom\Field24[local1]\Field5 - entityz(collider, $01)))
                            If (4.0 > local5) Then
                                local7 = $01
                                playerroom = playerroom\Field24[local1]
                                Exit
                            EndIf
                        EndIf
                    EndIf
                Next
            EndIf
        Else
            local7 = $01
        EndIf
    EndIf
    For local3 = Each rooms
        local4 = (Abs (local3\Field3 - entityx(collider, $01)))
        local5 = (Abs (local3\Field5 - entityz(collider, $01)))
        local3\Field8 = max(local4, local5)
        If (((16.0 > local4) And (16.0 > local5)) <> 0) Then
            For local1 = $00 To $07 Step $01
                If (local3\Field12[local1] <> $00) Then
                    local0 = entitydistance(local3\Field13[local1], collider)
                    If (local0 < local3\Field14[local1]) Then
                        local3\Field15[local1] = loopsound2(roomambience[local3\Field12[local1]], local3\Field15[local1], camera, local3\Field13[local1], local3\Field14[local1], 1.0)
                    EndIf
                EndIf
            Next
            If (((local7 = $00) And (playerroom <> local3)) <> 0) Then
                If (4.0 > local4) Then
                    If (4.0 > local5) Then
                        If (1.5 > (Abs (entityy(collider, $00) - entityy(local3\Field2, $00)))) Then
                            playerroom = local3
                        EndIf
                        local7 = $01
                    EndIf
                EndIf
            EndIf
        EndIf
        local6 = $01
        If (local3 = playerroom) Then
            local6 = $00
        EndIf
        If (local6 <> 0) Then
            If (isroomadjacent(playerroom, local3) <> 0) Then
                local6 = $00
            EndIf
        EndIf
        If (local6 <> 0) Then
            For local1 = $00 To $03 Step $01
                If (isroomadjacent(playerroom\Field24[local1], local3) <> 0) Then
                    local6 = $00
                    Exit
                EndIf
            Next
        EndIf
        If (local6 <> 0) Then
            hideentity(local3\Field2)
        Else
            showentity(local3\Field2)
            For local1 = $00 To $1F Step $01
                If (local3\Field16[local1] <> $00) Then
                    local0 = entitydistance(collider, local3\Field16[local1])
                    If (hidedistance > local0) Then
                        templightvolume = (((local3\Field17[local1] * local3\Field17[local1]) * ((hidedistance - local0) / hidedistance)) + templightvolume)
                    EndIf
                Else
                    Exit
                EndIf
            Next
            If (debughud <> 0) Then
                If (local3\Field36 > $00) Then
                    For local1 = $00 To (local3\Field36 - $01) Step $01
                        entitycolor(local3\Field37[local1], 255.0, 255.0, 0.0)
                        entityalpha(local3\Field37[local1], 0.2)
                    Next
                EndIf
            ElseIf (local3\Field36 > $00) Then
                For local1 = $00 To (local3\Field36 - $01) Step $01
                    entitycolor(local3\Field37[local1], 255.0, 255.0, 255.0)
                    entityalpha(local3\Field37[local1], 0.0)
                Next
            EndIf
        EndIf
    Next
    mapfound((Int floor((entityx(playerroom\Field2, $00) / 8.0))), (Int floor((entityz(playerroom\Field2, $00) / 8.0)))) = $01
    playerroom\Field1 = $01
    templightvolume = max((templightvolume / 4.5), 1.0)
    If (playerroom <> Null) Then
        entityalpha(getchild(playerroom\Field2, $02), 1.0)
        For local1 = $00 To $03 Step $01
            If (playerroom\Field24[local1] <> Null) Then
                If (playerroom\Field25[local1] <> Null) Then
                    local4 = (Abs (entityx(collider, $01) - entityx(playerroom\Field25[local1]\Field2, $01)))
                    local5 = (Abs (entityz(collider, $01) - entityz(playerroom\Field25[local1]\Field2, $01)))
                    If (0.0 = playerroom\Field25[local1]\Field7) Then
                        entityalpha(getchild(playerroom\Field24[local1]\Field2, $02), 0.0)
                    ElseIf (entityinview(playerroom\Field25[local1]\Field2, camera) = $00) Then
                        entityalpha(getchild(playerroom\Field24[local1]\Field2, $02), 0.0)
                    Else
                        entityalpha(getchild(playerroom\Field24[local1]\Field2, $02), 1.0)
                    EndIf
                EndIf
                For local2 = $00 To $03 Step $01
                    If (playerroom\Field24[local1]\Field24[local2] <> Null) Then
                        If (playerroom\Field24[local1]\Field24[local2] <> playerroom) Then
                            entityalpha(getchild(playerroom\Field24[local1]\Field24[local2]\Field2, $02), 0.0)
                        EndIf
                    EndIf
                Next
            EndIf
        Next
    EndIf
    Return $00
End Function
