Function placegrid_mapcreator%(arg0.rooms)
    Local local0.objects
    Local local1%
    Local local2%
    Local local3%
    Local local4%[6]
    Local local5.doors
    Local local6.items
    Local local7%
    Local local8%
    Local local9%
    Local local11%
    Local local12.waypoints
    Local local13%
    local0 = (First objects)
    For local3 = $00 To $06 Step $01
        local4[local3] = copyentity(local0\Field1[local3], $00)
        hideentity(local4[local3])
    Next
    For local2 = $00 To $12 Step $01
        For local1 = $00 To $12 Step $01
            If (arg0\Field23\Field0[((local2 * $13) + local1)] > $00) Then
                local7 = $00
                local8 = $00
                local7 = arg0\Field23\Field0[((local2 * $13) + local1)]
                local8 = (Int ((Float arg0\Field23\Field1[((local2 * $13) + local1)]) * 90.0))
                local9 = copyentity(local4[(local7 - $01)], $00)
                rotateentity(local9, 0.0, (Float local8), 0.0, $00)
                scaleentity(local9, roomscale, roomscale, roomscale, $01)
                positionentity(local9, (arg0\Field3 + ((Float local1) * 2.0)), 8.0, (arg0\Field5 + ((Float local2) * 2.0)), $01)
                Select arg0\Field23\Field0[((local2 * $13) + local1)]
                    Case $01
                        addlight(Null, (arg0\Field3 + ((Float local1) * 2.0)), ((368.0 * roomscale) + 8.0), (arg0\Field5 + ((Float local2) * 2.0)), $02, (500.0 * roomscale), $FF, $FF, $FF)
                    Case $02,$03
                        addlight(Null, (arg0\Field3 + ((Float local1) * 2.0)), ((368.0 * roomscale) + 8.0), (arg0\Field5 + ((Float local2) * 2.0)), $02, (500.0 * roomscale), $FF, $FF, $FF)
                    Case $03
                        addlight(Null, (arg0\Field3 + ((Float local1) * 2.0)), ((412.0 * roomscale) + 8.0), (arg0\Field5 + ((Float local2) * 2.0)), $02, (500.0 * roomscale), $FF, $FF, $FF)
                    Case $04,$05
                        addlight(Null, (arg0\Field3 + ((Float local1) * 2.0)), ((412.0 * roomscale) + 8.0), (arg0\Field5 + ((Float local2) * 2.0)), $02, (500.0 * roomscale), $FF, $FF, $FF)
                    Case $06
                        local5 = createdoor(arg0\Field0, ((arg0\Field3 + ((Float local1) * 2.0)) + ((cos(entityyaw(local9, $01)) * 240.0) * roomscale)), 8.0, ((arg0\Field5 + ((Float local2) * 2.0)) + ((sin(entityyaw(local9, $01)) * 240.0) * roomscale)), (entityyaw(local9, $01) + 90.0), Null, $00, $03, $00, "", $00)
                        positionentity(local5\Field3[$00], (entityx(local5\Field3[$00], $01) + (cos(entityyaw(local9, $01)) * 0.05)), (entityy(local5\Field3[$00], $01) + 0.0), ((entityz(local5\Field3[$00], $01) + (sin(entityyaw(local9, $01)) * 0.05)) - 0.02), $01)
                        positionentity(local5\Field3[$01], (entityx(local5\Field3[$01], $01) + (cos(entityyaw(local9, $01)) * 0.05)), (entityy(local5\Field3[$01], $01) + 0.0), ((entityz(local5\Field3[$01], $01) + (sin(entityyaw(local9, $01)) * 0.05)) - 0.02), $01)
                        addlight(Null, ((arg0\Field3 + ((Float local1) * 2.0)) + ((cos(entityyaw(local9, $01)) * 555.0) * roomscale)), ((469.0 * roomscale) + 8.0), ((arg0\Field5 + ((Float local2) * 2.0)) + ((sin(entityyaw(local9, $01)) * 555.0) * roomscale)), $02, (600.0 * roomscale), $FF, $FF, $FF)
                        local11 = createpivot($00)
                        rotateentity(local11, 0.0, (entityyaw(local9, $01) + 180.0), 0.0, $01)
                        positionentity(local11, ((arg0\Field3 + ((Float local1) * 2.0)) + ((cos(entityyaw(local9, $01)) * 552.0) * roomscale)), ((240.0 * roomscale) + 8.0), ((arg0\Field5 + ((Float local2) * 2.0)) + ((sin(entityyaw(local9, $01)) * 552.0) * roomscale)), $00)
                        If (arg0\Field21[$01] = Null) Then
                            arg0\Field21[$01] = local5
                            arg0\Field19[$03] = local11
                            positionentity(arg0\Field19[$00], (arg0\Field3 + ((Float local1) * 2.0)), 8.0, (arg0\Field5 + ((Float local2) * 2.0)), $01)
                        ElseIf (((arg0\Field21[$01] <> Null) And (arg0\Field21[$03] = Null)) <> 0) Then
                            arg0\Field21[$03] = local5
                            arg0\Field19[$05] = local11
                            positionentity(arg0\Field19[$01], (arg0\Field3 + ((Float local1) * 2.0)), 8.0, (arg0\Field5 + ((Float local2) * 2.0)), $01)
                        EndIf
                    Case $07
                        addlight(Null, (((arg0\Field3 + ((Float local1) * 2.0)) - ((sin(entityyaw(local9, $01)) * 504.0) * roomscale)) + ((cos(entityyaw(local9, $01)) * 16.0) * roomscale)), ((396.0 * roomscale) + 8.0), (((arg0\Field5 + ((Float local2) * 2.0)) + ((cos(entityyaw(local9, $01)) * 504.0) * roomscale)) + ((sin(entityyaw(local9, $01)) * 16.0) * roomscale)), $02, (500.0 * roomscale), $FF, $C8, $C8)
                        local6 = createitem("SCP-500-01", "scp500pill", (((arg0\Field3 + ((Float local1) * 2.0)) + ((cos(entityyaw(local9, $01)) * -208.0) * roomscale)) - ((sin(entityyaw(local9, $01)) * 1226.0) * roomscale)), ((80.0 * roomscale) + 8.0), (((arg0\Field5 + ((Float local2) * 2.0)) + ((sin(entityyaw(local9, $01)) * -208.0) * roomscale)) + ((cos(entityyaw(local9, $01)) * 1226.0) * roomscale)), $00, $00, $00, 1.0, $00)
                        entitytype(local6\Field1, $03, $00)
                        local6 = createitem("Night Vision Goggles", "nvgoggles", (((arg0\Field3 + ((Float local1) * 2.0)) - ((sin(entityyaw(local9, $01)) * 504.0) * roomscale)) + ((cos(entityyaw(local9, $01)) * 16.0) * roomscale)), ((80.0 * roomscale) + 8.0), (((arg0\Field5 + ((Float local2) * 2.0)) + ((cos(entityyaw(local9, $01)) * 504.0) * roomscale)) + ((sin(entityyaw(local9, $01)) * 16.0) * roomscale)), $00, $00, $00, 1.0, $00)
                        entitytype(local6\Field1, $03, $00)
                End Select
                arg0\Field23\Field3[((local2 * $13) + local1)] = local9
                local12 = createwaypoint((arg0\Field3 + ((Float local1) * 2.0)), 8.2, (arg0\Field5 + ((Float local2) * 2.0)), Null, arg0)
                arg0\Field23\Field4[((local2 * $13) + local1)] = local12
                If (local2 < $12) Then
                    If (arg0\Field23\Field4[(((local2 + $01) * $13) + local1)] <> Null) Then
                        local13 = (Int entitydistance(arg0\Field23\Field4[((local2 * $13) + local1)]\Field0, arg0\Field23\Field4[(((local2 + $01) * $13) + local1)]\Field0))
                        For local3 = $00 To $03 Step $01
                            If (arg0\Field23\Field4[((local2 * $13) + local1)]\Field4[local3] = arg0\Field23\Field4[(((local2 + $01) * $13) + local1)]) Then
                                Exit
                            ElseIf (arg0\Field23\Field4[((local2 * $13) + local1)]\Field4[local3] = Null) Then
                                arg0\Field23\Field4[((local2 * $13) + local1)]\Field4[local3] = arg0\Field23\Field4[(((local2 + $01) * $13) + local1)]
                                arg0\Field23\Field4[((local2 * $13) + local1)]\Field5[local3] = (Float local13)
                                Exit
                            EndIf
                        Next
                        For local3 = $00 To $03 Step $01
                            If (arg0\Field23\Field4[(((local2 + $01) * $13) + local1)]\Field4[local3] = arg0\Field23\Field4[((local2 * $13) + local1)]) Then
                                Exit
                            ElseIf (arg0\Field23\Field4[(((local2 + $01) * $13) + local1)]\Field4[local3] = Null) Then
                                arg0\Field23\Field4[(((local2 + $01) * $13) + local1)]\Field4[local3] = arg0\Field23\Field4[((local2 * $13) + local1)]
                                arg0\Field23\Field4[(((local2 + $01) * $13) + local1)]\Field5[local3] = (Float local13)
                                Exit
                            EndIf
                        Next
                    EndIf
                EndIf
                If (local2 > $00) Then
                    If (arg0\Field23\Field4[(((local2 - $01) * $13) + local1)] <> Null) Then
                        local13 = (Int entitydistance(arg0\Field23\Field4[((local2 * $13) + local1)]\Field0, arg0\Field23\Field4[(((local2 - $01) * $13) + local1)]\Field0))
                        For local3 = $00 To $03 Step $01
                            If (arg0\Field23\Field4[((local2 * $13) + local1)]\Field4[local3] = arg0\Field23\Field4[(((local2 - $01) * $13) + local1)]) Then
                                Exit
                            ElseIf (arg0\Field23\Field4[((local2 * $13) + local1)]\Field4[local3] = Null) Then
                                arg0\Field23\Field4[((local2 * $13) + local1)]\Field4[local3] = arg0\Field23\Field4[(((local2 - $01) * $13) + local1)]
                                arg0\Field23\Field4[((local2 * $13) + local1)]\Field5[local3] = (Float local13)
                                Exit
                            EndIf
                        Next
                        For local3 = $00 To $03 Step $01
                            If (arg0\Field23\Field4[(((local2 - $01) * $13) + local1)]\Field4[local3] = arg0\Field23\Field4[((local2 * $13) + local1)]) Then
                                Exit
                            ElseIf (arg0\Field23\Field4[((local2 * $13) + local1)]\Field4[local3] = Null) Then
                                arg0\Field23\Field4[(((local2 - $01) * $13) + local1)]\Field4[local3] = arg0\Field23\Field4[((local2 * $13) + local1)]
                                arg0\Field23\Field4[(((local2 - $01) * $13) + local1)]\Field5[local3] = (Float local13)
                                Exit
                            EndIf
                        Next
                    EndIf
                EndIf
                If (local1 > $00) Then
                    If (arg0\Field23\Field4[((local1 - $01) + (local2 * $13))] <> Null) Then
                        local13 = (Int entitydistance(arg0\Field23\Field4[((local2 * $13) + local1)]\Field0, arg0\Field23\Field4[((local1 - $01) + (local2 * $13))]\Field0))
                        For local3 = $00 To $03 Step $01
                            If (arg0\Field23\Field4[((local2 * $13) + local1)]\Field4[local3] = arg0\Field23\Field4[((local1 - $01) + (local2 * $13))]) Then
                                Exit
                            ElseIf (arg0\Field23\Field4[((local2 * $13) + local1)]\Field4[local3] = Null) Then
                                arg0\Field23\Field4[((local2 * $13) + local1)]\Field4[local3] = arg0\Field23\Field4[((local1 - $01) + (local2 * $13))]
                                arg0\Field23\Field4[((local2 * $13) + local1)]\Field5[local3] = (Float local13)
                                Exit
                            EndIf
                        Next
                        For local3 = $00 To $03 Step $01
                            If (arg0\Field23\Field4[((local1 - $01) + (local2 * $13))]\Field4[local3] = arg0\Field23\Field4[((local2 * $13) + local1)]) Then
                                Exit
                            ElseIf (arg0\Field23\Field4[((local2 * $13) + local1)]\Field4[local3] = Null) Then
                                arg0\Field23\Field4[((local1 - $01) + (local2 * $13))]\Field4[local3] = arg0\Field23\Field4[((local2 * $13) + local1)]
                                arg0\Field23\Field4[((local1 - $01) + (local2 * $13))]\Field5[local3] = (Float local13)
                                Exit
                            EndIf
                        Next
                    EndIf
                EndIf
                If (local1 < $12) Then
                    If (arg0\Field23\Field4[((local1 + $01) + (local2 * $13))] <> Null) Then
                        local13 = (Int entitydistance(arg0\Field23\Field4[((local2 * $13) + local1)]\Field0, arg0\Field23\Field4[((local1 + $01) + (local2 * $13))]\Field0))
                        For local3 = $00 To $03 Step $01
                            If (arg0\Field23\Field4[((local2 * $13) + local1)]\Field4[local3] = arg0\Field23\Field4[((local1 + $01) + (local2 * $13))]) Then
                                Exit
                            ElseIf (arg0\Field23\Field4[((local2 * $13) + local1)]\Field4[local3] = Null) Then
                                arg0\Field23\Field4[((local2 * $13) + local1)]\Field4[local3] = arg0\Field23\Field4[((local1 + $01) + (local2 * $13))]
                                arg0\Field23\Field4[((local2 * $13) + local1)]\Field5[local3] = (Float local13)
                                Exit
                            EndIf
                        Next
                        For local3 = $00 To $03 Step $01
                            If (arg0\Field23\Field4[((local1 + $01) + (local2 * $13))]\Field4[local3] = arg0\Field23\Field4[((local2 * $13) + local1)]) Then
                                Exit
                            ElseIf (arg0\Field23\Field4[((local2 * $13) + local1)]\Field4[local3] = Null) Then
                                arg0\Field23\Field4[((local1 + $01) + (local2 * $13))]\Field4[local3] = arg0\Field23\Field4[((local2 * $13) + local1)]
                                arg0\Field23\Field4[((local1 + $01) + (local2 * $13))]\Field5[local3] = (Float local13)
                                Exit
                            EndIf
                        Next
                    EndIf
                EndIf
            EndIf
        Next
    Next
    For local3 = $00 To $06 Step $01
        arg0\Field23\Field2[local3] = local4[local3]
    Next
    Return $00
End Function
